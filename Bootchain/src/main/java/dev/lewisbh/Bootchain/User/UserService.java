package dev.lewisbh.Bootchain.User;

import java.util.List;
import java.util.Objects;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

@Service
public class UserService {

	private final UserRepository userRepository;

	public UserService(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}

	public List<User> getUsers() {
		return userRepository.findAll();
	}

	public void addNewUser(User user) {
		userRepository.findUserByUsername(user.getUsername());
		System.out.println(user);
	}

	public void deleteUser(Long id) {
		if (!userRepository.existsById(id)) {
			throw new IllegalStateException("User with id:" + id + " does not exist.");
		}
		userRepository.deleteById(id);
	}

	@Transactional
	public void updateUser(Long userId, String username, String password) {
		User user = userRepository.findById(userId)
				.orElseThrow(() -> new IllegalStateException("user with id:" + userId + " does not exist."));
		if (username != null && username.length() > 0 && !Objects.equals(user.getUsername(), username)) {
			user.setUsername(username);
		}
		if (password != null && password.length() > 0 && !Objects.equals(user.getPassword(), password)) {
			user.setPassword(password);
		}
	}

}
