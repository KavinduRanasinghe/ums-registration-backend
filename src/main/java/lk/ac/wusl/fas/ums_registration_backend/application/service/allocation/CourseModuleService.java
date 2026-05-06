package lk.ac.wusl.fas.ums_registration_backend.application.service.allocation;

import lk.ac.wusl.fas.ums_registration_backend.domain.entity.CourseModule;
import lk.ac.wusl.fas.ums_registration_backend.domain.enums.Combination;
import lk.ac.wusl.fas.ums_registration_backend.domain.enums.Department;
import lk.ac.wusl.fas.ums_registration_backend.domain.repository.CourseModuleRepository;
import lk.ac.wusl.fas.ums_registration_backend.domain.util.CombinationMapping;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CourseModuleService {
	
	private final CourseModuleRepository repository;
	
	public List<CourseModule> getModulesByCombination(Combination comb, int level) {
		
		List<Department> departments = CombinationMapping.MAP.get(comb);
		
		return repository.findByDepartmentInAndLevel(departments, level);
	}
	
	public List<CourseModule> getAllModules() {
		
		return repository.findAll();
	}
	
	public CourseModule addModule(
			CourseModule module
	) {
		
		return repository.save(module);
	}
	
	public void deleteModule(
			String code
	) {
		
		repository.deleteById(code);
	}
}
