package bank.tools;

import java.math.BigDecimal;
import java.util.ArrayList;

import bank.entity.Account;
import bank.entity.AccountString;
import bank.entity.Card;
import bank.entity.CardString;
import bank.entity.Info;
import bank.entity.InfoString;

public class InfoDecimal2StringConverter {
	public static InfoString receiver(Info info) {
		InfoString result = new InfoString();
		ArrayList<AccountString> allAccount = new ArrayList<>();
		;
		ArrayList<AccountString> allActivedAccount = new ArrayList<>();
		ArrayList<CardString> allCreditCard = new ArrayList<>();
		;
		ArrayList<CardString> allActivedCreditCard = new ArrayList<>();
		ArrayList<CardString> allDebitCard = new ArrayList<>();
		ArrayList<CardString> allActivedDebitCard = new ArrayList<>();

		for (Account y : info.getAllAccount()) {
			AccountString new_data = new AccountString();
			new_data.setAaccount(y.getAaccount());
			new_data.setAactive(y.getAactive());
			new_data.setAbalance(y.getAbalance().toString());
			new_data.setAid(y.getAid());
			new_data.setAnickname(y.getAnickname());
			new_data.setAtype(y.getAtype());
			new_data.setAverify(y.getAverify());
			new_data.setMessage(y.getMessage());
			new_data.setStatuss(y.getStatuss());
			new_data.setUid(y.getUid());
			allAccount.add(new_data);
		}
		for (Account y : info.getAllActivedAccount()) {
			AccountString new_data = new AccountString();
			new_data.setAaccount(y.getAaccount());
			new_data.setAactive(y.getAactive());
			new_data.setAbalance(y.getAbalance().toString());
			new_data.setAid(y.getAid());
			new_data.setAnickname(y.getAnickname());
			new_data.setAtype(y.getAtype());
			new_data.setAverify(y.getAverify());
			new_data.setMessage(y.getMessage());
			new_data.setStatuss(y.getStatuss());
			new_data.setUid(y.getUid());
			allActivedAccount.add(new_data);
		}
		for (Card y : info.getAllCreditCard()) {
			CardString new_data = new CardString();
			new_data.setAid(y.getAid());
			new_data.setCacitve(y.getCacitve());
			new_data.setCccv(y.getCccv());
			new_data.setCccv_salt(y.getCccv_salt());
			new_data.setCcurrent(y.getCcurrent().toString());
			new_data.setCdate(y.getCdate());
			new_data.setCfailed(y.getCfailed());
			new_data.setCid(y.getCid());
			new_data.setClimit(y.getClimit().toString());
			new_data.setCnumber(y.getCnumber());
			new_data.setCtype(y.getCtype());
			new_data.setCverify(y.getCverify());
			new_data.setMessage(y.getMessage());
			new_data.setStatuss(y.getStatuss());
			new_data.setUid(y.getUid());
			allCreditCard.add(new_data);
		}
		for (Card y : info.getAllActivedCreditCard()) {
			CardString new_data = new CardString();
			new_data.setAid(y.getAid());
			new_data.setCacitve(y.getCacitve());
			new_data.setCccv(y.getCccv());
			new_data.setCccv_salt(y.getCccv_salt());
			new_data.setCcurrent(y.getCcurrent().toString());
			new_data.setCdate(y.getCdate());
			new_data.setCfailed(y.getCfailed());
			new_data.setCid(y.getCid());
			new_data.setClimit(y.getClimit().toString());
			new_data.setCnumber(y.getCnumber());
			new_data.setCtype(y.getCtype());
			new_data.setCverify(y.getCverify());
			new_data.setMessage(y.getMessage());
			new_data.setStatuss(y.getStatuss());
			new_data.setUid(y.getUid());
			allActivedCreditCard.add(new_data);
		}
		for (Card y : info.getAllDebitCard()) {
			CardString new_data = new CardString();
			new_data.setAid(y.getAid());
			new_data.setCacitve(y.getCacitve());
			new_data.setCccv(y.getCccv());
			new_data.setCccv_salt(y.getCccv_salt());
			new_data.setCcurrent(y.getCcurrent().toString());
			new_data.setCdate(y.getCdate());
			new_data.setCfailed(y.getCfailed());
			new_data.setCid(y.getCid());
			new_data.setClimit(y.getClimit().toString());
			new_data.setCnumber(y.getCnumber());
			new_data.setCtype(y.getCtype());
			new_data.setCverify(y.getCverify());
			new_data.setMessage(y.getMessage());
			new_data.setStatuss(y.getStatuss());
			new_data.setUid(y.getUid());
			allDebitCard.add(new_data);
		}
		for (Card y : info.getAllActivedDebitCard()) {
			CardString new_data = new CardString();
			new_data.setAid(y.getAid());
			new_data.setCacitve(y.getCacitve());
			new_data.setCccv(y.getCccv());
			new_data.setCccv_salt(y.getCccv_salt());
			new_data.setCcurrent(y.getCcurrent().toString());
			new_data.setCdate(y.getCdate());
			new_data.setCfailed(y.getCfailed());
			new_data.setCid(y.getCid());
			new_data.setClimit(y.getClimit().toString());
			new_data.setCnumber(y.getCnumber());
			new_data.setCtype(y.getCtype());
			new_data.setCverify(y.getCverify());
			new_data.setMessage(y.getMessage());
			new_data.setStatuss(y.getStatuss());
			new_data.setUid(y.getUid());
			allActivedDebitCard.add(new_data);
		}
		result.setAllAccount(allAccount.toArray(new AccountString[allAccount.size()]));
		result.setAllActivedAccount(allActivedAccount.toArray(new AccountString[allActivedAccount.size()]));
		result.setAllCreditCard(allCreditCard.toArray(new CardString[allCreditCard.size()]));
		result.setAllActivedCreditCard(allActivedCreditCard.toArray(new CardString[allActivedCreditCard.size()]));
		result.setAllDebitCard(allDebitCard.toArray(new CardString[allDebitCard.size()]));
		result.setAllActivedDebitCard(allActivedDebitCard.toArray(new CardString[allActivedDebitCard.size()]));
		result.setLasttime(info.getLasttime());
		result.setTotalMoney(info.getTotalMoney());
		result.setUid(info.getUid());
		result.setUname(info.getUname());
		return result;
	}
}
