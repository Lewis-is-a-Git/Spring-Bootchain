package dev.lewisbh.Bootchain.User;

import static javax.persistence.GenerationType.SEQUENCE;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity(name = "Users")
@Table(name = "users", uniqueConstraints = { @UniqueConstraint(name = "username_unique", columnNames = "username") })
public class User {

	/**
	 * @param id
	 * @param username
	 * @param password
	 */
	public User(int id, String username, String password) {
		this.id = id;
		this.username = username;
		this.balance = BigDecimal.ZERO;
		this.password = password;
	}

	/**
	 * @param username
	 * @param password
	 */
	public User(String username, String password) {
		this.username = username;
		this.balance = BigDecimal.ZERO;
		this.password = password;
	}

	public long getId() {
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
	@SequenceGenerator(name = "user_sequence", sequenceName = "user_sequence", allocationSize = 1)
	@GeneratedValue(strategy = SEQUENCE, generator = "user_sequence")
	@Column(name = "id")
	private long id;

	@Column(name = "username", nullable = false, columnDefinition = "TEXT")
	private String username;

	@Column(name = "balance", nullable = false, columnDefinition = "MONEY")
	private BigDecimal balance;

	@Column(name = "password", nullable = false, columnDefinition = "TEXT")
	private String password;

	public void setUsername(String username) {
		this.username = username;
	}

}
