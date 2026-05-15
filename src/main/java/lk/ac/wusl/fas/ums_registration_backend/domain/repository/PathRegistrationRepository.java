package lk.ac.wusl.fas.ums_registration_backend.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

import lk.ac.wusl.fas.ums_registration_backend.domain.entity.PathRegistration;

public interface PathRegistrationRepository
		extends JpaRepository<PathRegistration, UUID> {
	
	Optional<PathRegistration> findByRegNo(
			String regNo
	);
}
