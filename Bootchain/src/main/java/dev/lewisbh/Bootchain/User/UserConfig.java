package dev.lewisbh.Bootchain.User;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserConfig {

	CommandLineRunner conmCommandLineRunner(UserRepository repository) {
		return args -> {
			User rocky = new User("Rocky", "password");
			User lewis = new User("Lewis", "password");
			repository.saveAll(List.of(rocky, lewis));
		};
	}
}
