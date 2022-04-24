package dev.lewisbh.Bootchain.Blockchain;

import java.math.BigDecimal;

import dev.lewisbh.Bootchain.User.User;

public class Transaction {

	BigDecimal amount;
	User sender;
	User recipient;

	public Transaction(BigDecimal amount, User sender, User recipient) {
		this.amount = amount;
		this.sender = sender;
		this.recipient = recipient;
	}

}
