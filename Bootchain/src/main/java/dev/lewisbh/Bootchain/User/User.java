package dev.lewisbh.Bootchain.User;

public class User {

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", balance=" + "]";
	}

	public User(int id, String username) {
		super();
		this.id = id;
		this.username = username;
	}

	private int id;
	private String username;

}
