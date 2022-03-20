package dev.lewisbh.Bootchain.User;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class UserService {

	public List<User> getUsers() {
		// we want this to come from the database
		return List.of(new User(0, "Rocky"), new User(1, "Lewis"));
	}

}
