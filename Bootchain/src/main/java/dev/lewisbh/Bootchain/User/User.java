package dev.lewisbh.Bootchain.User;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity(name = "User")
@Table(name = "user", uniqueConstraints = { @UniqueConstraint(name = "username_unique", columnNames = "username") })
public class User {

	public User(int id, String username, String password) {
		super();
		this.id = id;
		this.username = username;
		this.balance = BigDecimal.ZERO;
		this.password = password;
	}

	public int getId() {
		return id;
	}

	public String getUsername() {
		return username;
	}

	public BigDecimal getBalance() {
		return balance;
	}

	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", balance=" + balance + "]";
	}

	@Id
	@SequenceGenerator(name = "user_sequence", sequenceName = "user_sequence", allocationSize = 1

	)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "userr_sequence")
	private int id;
	private String username;
	private BigDecimal balance;
	private String password;

}
