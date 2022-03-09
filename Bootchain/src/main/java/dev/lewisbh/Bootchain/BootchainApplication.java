package dev.lewisbh.Bootchain;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.lewisbh.Bootchain.User.User;

@SpringBootApplication
@RestController
public class BootchainApplication {

	public static void main(String[] args) {
		SpringApplication.run(BootchainApplication.class, args);
	}

	@GetMapping
	public List<User> hello() {
		return List.of(new User(0, "Rocky"), new User(1, "Lewis"));
	}

}
