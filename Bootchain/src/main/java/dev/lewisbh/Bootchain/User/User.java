package dev.lewisbh.Bootchain.User;

import java.math.BigDecimal;

public class User {

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", balance=" + balance + "]";
	}

	public User(int id, String username) {
		super();
		this.id = id;
		this.username = username;
		this.balance = new BigDecimal(0);
	}

	public BigDecimal getBalance() {
		return balance;
	}

	public void modifyBalance(BigDecimal balance) {
		this.balance = this.balance.add(balance);
	}

	private int id;
	private String username;
	private BigDecimal balance;

}
