package lk.ac.wusl.fas.ums_registration_backend.domain.repository;

import lk.ac.wusl.fas.ums_registration_backend.domain.entity.RegisteredModule;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface RegisteredModuleRepository
		extends JpaRepository<RegisteredModule, UUID> {
	
	List<RegisteredModule> findByStudentId(UUID studentId);
}
