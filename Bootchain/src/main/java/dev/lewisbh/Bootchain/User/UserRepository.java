package dev.lewisbh.Bootchain.User;

import java.util.Optional;

import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	@Query("SELECT u FROM User u WHERE u.username = ?1")
	Optional<User> findUserByUsername(String username);

	@Query("INSERT u INTO User u WHERE u.userId = ?1")
	Optional<User> updateUser(Long userId);
}
