package com.cg.repo;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.TreeMap;

import com.cg.dto.Customer;
import com.cg.exception.BankException;

public interface WalletRepo {
	String addCustomer(Customer customer);
	Customer showBalance(String mobileNum, String password) throws SQLException;
	Customer findCustomer(String mobileNum, String password) throws SQLException;
	void deposit(Customer customer, BigDecimal amount) throws SQLException, ClassNotFoundException, BankException;
	boolean withdraw(Customer customer, BigDecimal amount) throws ClassNotFoundException, SQLException, BankException;
	boolean customerExists(String receiverMobile) throws SQLException;
	Customer transfer(String senderMobile, String receiverMobile, BigDecimal amount) throws ClassNotFoundException, SQLException, BankException;
	String printTransactions(Customer customer) throws ClassNotFoundException, SQLException;
}