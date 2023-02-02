package bank.tools;

import java.util.Arrays;

import org.junit.Test;
import bank.entity.Account;


public class AccountUtils {


	public boolean verify(String aaccount) {
//		String aaccount = "123456789012";
		char[] numbers = new char[10];
		for (int i = 0; i < 10; i++) {
			numbers[i] = String.valueOf(i).charAt(0);
		}
		if (aaccount.length() != 12) {
			return false;
		}
		for (int i = 0; i < 12; i++) {
//			System.out.println(Arrays.binarySearch(numbers, aaccount.charAt(i)));
			if (Arrays.binarySearch(numbers, aaccount.charAt(i)) < 0) {
				return false;
			}
		}
//		System.out.println(numbers);
		int[] acc_int = new int[12];
		int acc_int_weighted_total = 0;
		int j = -1;
		for (int i = 0; i < 12; i++) {
			if (i == 11) {
				j = 1;
			} else if (i % 4 == 0) {
				j = 7;
			} else if (i % 4 == 1) {
				j = 4;
			} else if (i % 4 == 2) {
				j = 1;
			} else if (i % 4 == 3) {
				j = 4;
			}
			acc_int[i] = Integer.parseInt(aaccount.substring(i, i + 1));
			if (acc_int[i] * j < 10) {
				acc_int_weighted_total += acc_int[i] * j;
			} else {
				acc_int_weighted_total += (acc_int[i] * j) / 10 + (acc_int[i] * j) % 10;
			}
		}
//		System.out.println(acc_int_weighted_total);
		if (acc_int_weighted_total % 10 == 0) {
			return true;
		}
		;
		return false;
	}

	public String generator(Account lastAccount) {
		System.out.println(lastAccount);
		if(lastAccount==null) {
			return "000000000019";
		}
		Long lastAccount_long = Long.parseLong(lastAccount.getAaccount());
		String result = null;
		boolean verified=false;
		while (!verified) {
//			System.out.println(lastAccount_long);
			lastAccount_long++;
			if (verify(String.format("%012d",(lastAccount_long)))) {
				result = String.format("%012d",(lastAccount_long));
				verified=true;
			}
		}
		return result;

	}

	@Test
	public void test() {
		System.out.println(verify("000000012317"));
//		System.out.println(generator());
	}
}
