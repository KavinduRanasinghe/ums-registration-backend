package lk.ac.wusl.fas.ums_registration_backend.domain.repository;

import lk.ac.wusl.fas.ums_registration_backend.domain.entity.CourseModule;
import lk.ac.wusl.fas.ums_registration_backend.domain.enums.Department;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CourseModuleRepository
		extends JpaRepository<CourseModule, String> {
	
	List<CourseModule>
	findByDepartmentInAndLevel(
			List<Department> departments,
			int level
	);
	
	List<CourseModule> findByDepartment(
			Department department
	);
}
