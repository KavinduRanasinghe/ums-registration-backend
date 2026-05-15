package lk.ac.wusl.fas.ums_registration_backend.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;
import java.util.UUID;

import lk.ac.wusl.fas.ums_registration_backend.domain.entity.Student;

public interface StudentRepository extends JpaRepository<Student, UUID> {
	
	Optional<Student> findByRegNo(String regNo);
}
