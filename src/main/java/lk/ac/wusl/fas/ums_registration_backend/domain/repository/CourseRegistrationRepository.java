package lk.ac.wusl.fas.ums_registration_backend.domain.repository;

import lk.ac.wusl.fas.ums_registration_backend.domain.entity.CourseRegistration;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRegistrationRepository extends JpaRepository<CourseRegistration, UUID> {
	
	boolean existsByStudentId(UUID id);
}
