package com.cg.service;

import java.math.BigDecimal;
import java.sql.SQLException;

import com.cg.dto.Customer;
import com.cg.exception.BankException;
import com.cg.exception.InsufficientBalanceException;
import com.cg.exception.InvalidInputException;

public interface WalletService {

	void checkName(String name) throws InvalidInputException;

	void checkMobileNumber(String mobileNumber) throws InvalidInputException;

	void checkPassword(String password) throws InvalidInputException;

	void checkEmail(String emailId) throws InvalidInputException;

	String addCustomer(Customer customer) throws InvalidInputException;

	Customer showBalance(String mobileNum, String password) throws InvalidInputException, SQLException;

	Customer check(String mobileNum, String password) throws InvalidInputException, SQLException;

	void deposit(Customer customer, BigDecimal amount)
			throws ClassNotFoundException, SQLException, InvalidInputException, BankException;

	boolean withDraw(Customer customer, BigDecimal amount)
			throws InsufficientBalanceException, ClassNotFoundException, SQLException, BankException;

	boolean isFound(String receiverMobile) throws InvalidInputException, SQLException;

	Customer transfer(String senderMobile, String receiverMobile, BigDecimal amount) throws InterruptedException,
			InsufficientBalanceException, ClassNotFoundException, SQLException, BankException;

	String printTransactions(Customer customer) throws ClassNotFoundException, SQLException;

}