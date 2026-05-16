package lk.ac.wusl.fas.ums_registration_backend.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

import lk.ac.wusl.fas.ums_registration_backend.domain.entity.StudentResult;

public interface StudentResultRepository
		extends JpaRepository<StudentResult, UUID> {
	
	List<StudentResult>
	findByRegNo(
			String regNo
	);
}
