package lk.ac.wusl.fas.ums_registration_backend.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

import lk.ac.wusl.fas.ums_registration_backend.domain.entity.Lecturer;

public interface LecturerRepository
		extends JpaRepository<Lecturer, UUID> {
	
	Optional<Lecturer> findByLecturerId(
			String lecturerId
	);
	
	Optional<Lecturer> findByEmail(
			String email
	);
}
