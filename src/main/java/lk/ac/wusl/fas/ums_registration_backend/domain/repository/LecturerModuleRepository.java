package lk.ac.wusl.fas.ums_registration_backend.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

import lk.ac.wusl.fas.ums_registration_backend.domain.entity.LecturerModule;

public interface LecturerModuleRepository
		extends JpaRepository<LecturerModule, UUID> {
	
	List<LecturerModule> findByLecturerId(
			String lecturerId
	);
	
	
}
