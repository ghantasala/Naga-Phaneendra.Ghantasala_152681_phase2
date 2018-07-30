package com.cg.service;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.cg.dto.Customer;
import com.cg.exception.BankException;
import com.cg.exception.IBankException;
import com.cg.exception.InsufficientBalanceException;
import com.cg.exception.InvalidInputException;
import com.cg.repo.WalletRepo;
import com.cg.repo.WalletRepoImpl;

public class WalletServiceImpl implements WalletService {
	static WalletRepo WalletDao = null;

	static {

		WalletDao = new WalletRepoImpl();
	}

	public void checkName(String name) throws InvalidInputException {
		Pattern pattern = Pattern.compile("[a-zA-Z]{1,}");
		Matcher matcher = pattern.matcher(name);
		if (!(matcher.matches())) {
			throw new InvalidInputException(IBankException.nameException);
		}
	}

	public void checkMobileNumber(String mobileNumber) throws InvalidInputException {

		Pattern pattern = Pattern.compile("[7-9]{1}[0-9]{9}");
		Matcher matcher = pattern.matcher(mobileNumber);
		if (!(matcher.matches())) {
			throw new InvalidInputException(IBankException.mobileNumberException);
		}
	}

	public void checkPassword(String password) throws InvalidInputException {
		Pattern pattern = Pattern.compile(".*(?=.{8,})(?=..*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=]).*" + "");
		Matcher matcher = pattern.matcher(password);
		if (!(matcher.matches())) {
			throw new InvalidInputException(IBankException.passwordException);
		}

	}

	public void checkEmail(String emailId) throws InvalidInputException {
		Pattern pattern = Pattern.compile("[a-z]{1}[a-z0-9._]{1,}@[a-zA-Z0-9]{1,}.com");
		Matcher matcher = pattern.matcher(emailId);
		if (!(matcher.matches())) {
			throw new InvalidInputException(IBankException.emailIdException);
		}

	}

	public String addCustomer(Customer customer) throws InvalidInputException {
		String result = null;
		result = WalletDao.addCustomer(customer);
		if(result==null)
		 throw new InvalidInputException(IBankException.ACCOUNTEXISTS);
		 
		return result;
	}

	public Customer showBalance(String mobileNum, String password) throws InvalidInputException, SQLException {
		Customer result = null;
		result = WalletDao.showBalance(mobileNum, password);

		if (result == null)
			throw new InvalidInputException(IBankException.invalidDetails);

		return result;
	}

	public Customer check(String mobileNum, String password) throws InvalidInputException, SQLException {
		Customer result = null;
		result = WalletDao.findCustomer(mobileNum, password);

		if (result == null)
			throw new InvalidInputException(IBankException.invalidDetails);
		return result;
	}

	public void deposit(Customer customer, BigDecimal amount)
			throws ClassNotFoundException, SQLException, InvalidInputException, BankException {

		WalletDao.deposit(customer, amount);
	}

	public boolean withDraw(Customer customer, BigDecimal amount)
			throws InsufficientBalanceException, ClassNotFoundException, SQLException, BankException {
		boolean result = false;		
		result = WalletDao.withdraw(customer, amount);		
		if (result == false) {
			throw new InsufficientBalanceException(IBankException.insufficientFunds);
		}
		return result;
	}
	public boolean isFound(String receiverMobile) throws InvalidInputException, SQLException {
		boolean result = false;		
		if (WalletDao.customerExists(receiverMobile)) {
			result = true;
		}		
		if (result == false)
			throw new InvalidInputException(IBankException.mobileNumberNotExists);
		return result;
	}

	public Customer transfer(String senderMobile, String receiverMobile, BigDecimal amount)
			throws InterruptedException, InsufficientBalanceException, ClassNotFoundException, SQLException, BankException {		
		Customer result=null;
		result=WalletDao.transfer(senderMobile,receiverMobile,amount);	
		return result;
	}
	public String printTransactions(Customer customer) throws ClassNotFoundException, SQLException {
	    String builder = WalletDao.printTransactions(customer);
		return builder;
	}
}