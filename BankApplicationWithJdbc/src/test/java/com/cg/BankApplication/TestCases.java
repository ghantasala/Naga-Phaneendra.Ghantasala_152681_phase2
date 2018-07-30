package com.cg.BankApplication;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.TreeMap;

import org.junit.Test;

import com.cg.dto.Customer;
import com.cg.dto.Wallet;
import com.cg.exception.BankException;
import com.cg.exception.InsufficientBalanceException;
import com.cg.exception.InvalidInputException;
import com.cg.service.WalletService;
import com.cg.service.WalletServiceImpl;

public class TestCases {
	public static WalletService iWalletService=new WalletServiceImpl();
    @Test
	public void addCustomerTestTrue() throws InvalidInputException
	{
		Customer customer1 = new Customer("9876543210","Phani","Phanii@123","phani@gmail.com",new Wallet());
		assertEquals("9876543210",iWalletService.addCustomer(customer1));
			
	}
    @Test
  	public void addCustomerTestFalse() throws InvalidInputException
  	{

  		Customer customer2 = new Customer("888576224","kiran","Kirann@123","kiran@gmail.com",new Wallet());
  		assertNotEquals("56968621",iWalletService.addCustomer(customer2));
  		
  	}
	

	@Test
	public void initBalanceTest() throws InvalidInputException
	{
		Customer customer1 = new Customer("9856741230","Varun","Varun@123","pulivarun125@gmail.com",new Wallet());
		iWalletService.addCustomer(customer1);
		assertEquals(BigDecimal.valueOf(0.0),customer1.getWallet().getBalance());
		
	}
	
	@Test
	public void depositMoneyTest() throws InvalidInputException, SQLException, ClassNotFoundException, BankException
	{
		Customer customer2 = new Customer("8529361470","Vinnay","Vinayy1$","vinay@gmail.com",new Wallet());
		iWalletService.addCustomer(customer2);
		iWalletService.deposit(customer2, BigDecimal.valueOf(11500.00));
		Customer result = iWalletService.showBalance("8529361470", "Vinayy1$");
		assertEquals(BigDecimal.valueOf(11500.00),result.getWallet().getBalance());
	}
	@Test
	public void withdrawMoneyTestTrue() throws InsufficientBalanceException, ClassNotFoundException, InvalidInputException, SQLException, BankException 
	{
		Customer customer2 = new Customer("8885599775","Vineeth","Vineeth@123","balusanivineeth8@gmail.com",new Wallet());
		iWalletService.addCustomer(customer2);
		iWalletService.deposit(customer2, BigDecimal.valueOf(8500.00));
		assertTrue(iWalletService.withDraw(customer2, BigDecimal.valueOf(3000.00)));
	}

	
	@Test(expected = InsufficientBalanceException.class)
	public void withdrawMoneyTestFalse() throws InsufficientBalanceException, ClassNotFoundException, SQLException, BankException
	{
		Customer customer2 = new Customer("8885599774","Vineeth","Vineeth@123","balusanivineeth8@gmail.com",new Wallet());
		iWalletService.addCustomer(customer2);
		iWalletService.deposit(customer2, BigDecimal.valueOf(8500.00));
		assertFalse(iWalletService.withDraw(customer2, BigDecimal.valueOf(9000.00)));
	}

}