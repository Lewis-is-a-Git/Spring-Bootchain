package dev.lewisbh.Bootchain.User;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api/v1/user")
public class UserController {

	private final UserService userService;

	@Autowired
	public UserController(UserService userService) {
		this.userService = userService;
	}

	@GetMapping
	public List<User> getUsers() {
		return userService.getUsers();
	}

	@PostMapping
	public void registerNewUser(@RequestBody User user) {
		userService.addNewUser(user);
	}

	@DeleteMapping(path = "{userId}")
	public void deleteUser(@PathVariable("userId") Long userId) {
		userService.deleteUser(userId);
	}

	@PutMapping(path = "{userId}")
	public void updateUser(@PathVariable("userId") Long userId, @RequestParam(required = false) String username,
			@RequestParam(required = false) String email) {
		userService.updateUser(userId, username, email);
	}

}
