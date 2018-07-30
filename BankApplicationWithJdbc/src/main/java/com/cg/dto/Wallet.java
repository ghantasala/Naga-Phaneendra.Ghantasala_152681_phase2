package com.cg.dto;
import java.math.BigDecimal;

public class Wallet {
private BigDecimal balance;
public Wallet() {
	this.balance=BigDecimal.valueOf(0.0);
}


public Wallet(BigDecimal amount) {
	this.balance=amount;
}

public BigDecimal getBalance() {
	return balance;
}

public void setBalance(BigDecimal balance) {
	this.balance = balance;
}

@Override
	public String toString() {
	return " balance="+balance;
}

}