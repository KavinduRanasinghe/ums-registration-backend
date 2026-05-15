package lk.ac.wusl.fas.ums_registration_backend.domain.repository;

import lk.ac.wusl.fas.ums_registration_backend.domain.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface UserRepository
		extends JpaRepository<User, UUID> {
	
	Optional<User> findByUsername(String username);
}
