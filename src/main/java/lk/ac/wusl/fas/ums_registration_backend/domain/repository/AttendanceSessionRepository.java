package lk.ac.wusl.fas.ums_registration_backend.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

import lk.ac.wusl.fas.ums_registration_backend.domain.entity.AttendanceSession;

public interface AttendanceSessionRepository
		extends JpaRepository<AttendanceSession, UUID> {
	
	Optional<AttendanceSession>
	findBySessionCodeAndActiveTrue(
			String sessionCode
	);
}
