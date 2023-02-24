package bank.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bank.dao.TransferDAOInterface;
import bank.entity.Account;
import bank.entity.Status;
import bank.entity.Transfer;
import bank.tools.JavaMailTools;
import jakarta.mail.MessagingException;
import jakarta.transaction.Transactional;

@Service
public class TransferServiceImpl implements TransferService {

	@Autowired
	TransferDAOInterface transferDAOInterface;
	@Autowired
	AccountService accountService;
	@Autowired
	UserService userService;
	@Autowired
	JavaMailTools javaMailTools;

	@Override
	@Transactional
	public Transfer createTransfer(Transfer transfer) {
		return transferDAOInterface.save(transfer);
	}

	@Override
	@Transactional
	public Transfer queryTransfer(Integer tid) {
		return transferDAOInterface.findByTid(tid);
	}

	@Override
	@Transactional
	public Transfer[] queryTransferByAccount(Account account) {
		if (account == null || account.getAaccount() == null || account.getUid() == null
				|| userService.queryUser(account.getUid()) == null) {
			return null;
		}
		ArrayList<Transfer> result = transferDAOInterface.findBySenderAccount(account.getAaccount());
		if (result == null) {
			return null;
		}
		for (Transfer y : result) {
			if (y.getBalance() != null) {
				y.setBalanceString(y.getBalance().toString());
			}
			y.setAmountString(y.getAmount().toString());
		}
		return result.toArray(new Transfer[result.size()]);
	}

	@Override
	@Transactional
	public Transfer updateTransfer(Transfer transfer) {
		return transferDAOInterface.save(transfer);
	}

	@Override
	@Transactional
	public boolean deleteTransfer(Integer tid) {
		transferDAOInterface.delete(queryTransfer(tid));
		return queryTransfer(tid) == null ? true : false;
	}

	@Override
	@Transactional
	public Status excuteTransfer(Integer tid) {
		Transfer transfer = transferDAOInterface.findByTid(tid);
		Status result = new Status();
		if (transfer.getStatuss() != 0 && transfer.getStatuss() != 3) {
			result.setStatuss(2);
			result.setErrorCode(6);
			result.setMessage("transferAlreadyDoneOrNotExist");
			return result;
		}
		if (transfer.getAmount().compareTo(new BigDecimal(0)) < 1) {
			transfer.setVerify(null);
			transfer.setOperateTime(
					LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")).toString());
			transfer.setStatuss(2);
			transfer.setError(7);

			updateTransfer(transfer);
			result.setStatuss(3);
			result.setErrorCode(7);
			result.setMessage("amountLessThanOrEqualsZero");
			return result;
		}
		if (accountService.queryAccountByAaccount(transfer.getSenderAccount()).getAbalance()
				.compareTo(transfer.getAmount()) == -1) {
			transfer.setOperateTime(
					LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")).toString());
			transfer.setVerify(null);
			transfer.setStatuss(2);
			transfer.setError(1);
			updateTransfer(transfer);
			result.setStatuss(3);
			result.setErrorCode(1);
			result.setMessage("insufficientBalance");
			return result;
		}
		;
		if (transfer.getSenderAccount().equals(transfer.getReceiverAccount())) {
			transfer.setOperateTime(
					LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")).toString());
			transfer.setVerify(null);
			transfer.setStatuss(2);
			transfer.setError(8);
			updateTransfer(transfer);
			result.setStatuss(3);
			result.setErrorCode(8);
			result.setMessage("transferToSendAccount");
			return result;
		}
		if (accountService.queryAccountByAaccount(transfer.getReceiverAccount()) == null) {
			transfer.setOperateTime(
					LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")).toString());
			transfer.setVerify(null);
			transfer.setStatuss(2);
			transfer.setError(2);
			updateTransfer(transfer);
			result.setStatuss(3);
			result.setErrorCode(2);
			result.setMessage("accountNotExist");
			return result;
		}
		if (accountService.queryAccountByAaccount(transfer.getSenderAccount()).getAactive() == 0
				|| accountService.queryAccountByAaccount(transfer.getSenderAccount()).getAactive() == 2
				|| accountService.queryAccountByAaccount(transfer.getReceiverAccount()).getAactive() == 0
				|| accountService.queryAccountByAaccount(transfer.getReceiverAccount()).getAactive() == 2) {
			transfer.setVerify(null);
			transfer.setOperateTime(
					LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")).toString());
			transfer.setStatuss(2);
			transfer.setError(3);
			updateTransfer(transfer);
			result.setStatuss(3);
			result.setErrorCode(3);
			result.setMessage("accountNotActive");
			return result;
		}
		if (transfer.getCurrencyType() == 1
				&& !(String.valueOf(transfer.getAmount()).substring(String.valueOf(transfer.getAmount()).length() - 4,
						String.valueOf(transfer.getAmount()).length()).equals("0000"))) {
			transfer.setVerify(null);
			transfer.setOperateTime(
					LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")).toString());
			transfer.setStatuss(2);
			transfer.setError(4);

			updateTransfer(transfer);
			result.setStatuss(3);
			result.setErrorCode(4);
			result.setMessage("amountCurrencyTypeError");
			return result;
		}

		Account sender = accountService.queryAccountByAaccount(transfer.getSenderAccount());
		Account receiver = accountService.queryAccountByAaccount(transfer.getReceiverAccount());
		sender.setAbalance(sender.getAbalance().subtract(transfer.getAmount()));
		accountService.updateAccount(sender);
		receiver.setAbalance(receiver.getAbalance().add(transfer.getAmount()));
		accountService.updateAccount(receiver);
		transfer.setBalance((sender.getAbalance()));
		transfer.setVerify(null);
		transfer.setStatuss(1);
		transfer.setOperateTime(
				LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")).toString());
		updateTransfer(transfer);
		result.setStatuss(1);
		result.setMessage(String
				.valueOf(accountService.queryAccountByAaccount(transfer.getSenderAccount()).getAbalance().toString())); // balance
																														// after
																														// transfer
		return result;
	}

	@Override
	@Transactional
	public ArrayList<Status> excuteScheduleTransfer(String dateTime) {
		ArrayList<Transfer> transfers = transferDAOInterface
				.findByVerifyEqualsAndScheduleTimeLessThanEqualAndStatussEquals(null, dateTime, 3);
		ArrayList<Status> results = new ArrayList<>();
//		ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
		for (Transfer y : transfers) {
			Status result = excuteTransfer(y.getTid());
			results.add(result);
			String reason = "";
			String balance = "";
			if (result.getStatuss() != 1) {
				if (result.getErrorCode() == 1) {
					reason = "001 餘額不足";
				} else if (result.getErrorCode() == 2) {
					reason = "002 接收帳號不存在";
				} else if (result.getErrorCode() == 3) {
					reason = "003 您的帳號或接收帳號未啟用";
				} else if (result.getErrorCode() == 4) {
					reason = "004 貨幣單位輸入錯誤";
				} else if (result.getErrorCode() == 7) {
					reason = "007 匯款金額小於等於0元";
				} else if (result.getErrorCode() == 8) {
					reason = "008 接收帳號為轉出帳號";
				} else if (result.getErrorCode() == 9) {
					reason = "009 時間不合法";
			}
			}else {
				balance = "可用餘額為"+y.getBalance().toString();
			}
			try {
				javaMailTools.sendScheduleTransferResult("金發財商業銀行預約轉帳結果通知",
						userService.queryUser(accountService.queryAccountByAaccount(y.getSenderAccount()).getUid())
								.getUname(),
						userService.queryUser(accountService.queryAccountByAaccount(y.getSenderAccount()).getUid())
								.getUemail(),
						y.getOperateTime(), y.getReceiverBankCode(), y.getReceiverAccount(),
						y.getCurrencyType() == 1 ? "台幣" : "美金", y.getAmount().toString(), y.getTid(),
						result.getStatuss() == 1 || result.getStatuss() == 0 ? "成功" : "失敗",
						result.getStatuss() == 1 || result.getStatuss() == 0 ? balance : reason);
			} catch (MessagingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		return results;
	}

}
