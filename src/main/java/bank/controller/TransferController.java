package bank.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import bank.entity.Status;
import bank.entity.Transfer;
import bank.service.AccountService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping

public class TransferController {
	@Autowired
	AccountService accountService;

	@PostMapping("doTransfer")
	public Status doTransfer(@RequestBody Transfer transfer) {
		Status result = new Status();
		if (accountService.queryAccountByAaccount(transfer.getSender_account()).getAid() == null
				|| accountService.queryAccountByAaccount(transfer.getReceiver_account()).getAid() == null) {
			result.setStatuss(3);
			result.setMessage("accountNotExist");
		}
		if (transfer.getCurrency_type() == 1 && transfer.getAmount_string().contains(".")) {
			result.setStatuss(3);
			result.setMessage("amountCurrencyTypeError");
		}
		return null;
	}
}
