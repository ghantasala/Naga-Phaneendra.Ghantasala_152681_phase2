package com.cg.exception;

public interface IBankException {
	String nameException ="Enter Valid Name";
	String mobileNumberException = "Enter Valid Mobile Number ";
	String passwordException ="Enter Valid Password";
	String emailIdException = " enter valid email id";
	String invalidDetails = "Given details are incorrect ";
	String insufficientFunds = "Insufficicnet account balance";
	String ACCOUNTEXISTS = "Account already exists with the given mobile number";
	String transFailed = "Network issue! Please try again";
	String sqlException = "Cannot connect to database";
	String mobileNumberNotExists = "Account doesnt exists with given mobile number";
}
