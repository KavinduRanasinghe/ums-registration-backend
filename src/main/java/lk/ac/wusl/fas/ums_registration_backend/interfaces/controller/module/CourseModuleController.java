package lk.ac.wusl.fas.ums_registration_backend.interfaces.controller.module;

import lk.ac.wusl.fas.ums_registration_backend.application.service.allocation.CourseModuleService;
import lk.ac.wusl.fas.ums_registration_backend.domain.entity.CourseModule;
import lk.ac.wusl.fas.ums_registration_backend.domain.enums.Combination;
import lk.ac.wusl.fas.ums_registration_backend.domain.enums.Department;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/modules")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class CourseModuleController {
	
	private final CourseModuleService service;
	
	// GET ALL MODULES
	@GetMapping
	public List<CourseModule> getAllModules() {
		
		return service.getAllModules();
	}
	
	// ADD MODULE
	@PostMapping
	public CourseModule addModule(
			@RequestBody CourseModule module
	) {
		
		return service.addModule(module);
	}
	
	// DELETE MODULE
	@DeleteMapping("/{code}")
	public void deleteModule(
			@PathVariable String code
	) {
		
		service.deleteModule(code);
	}
	
	// GET MODULES BY COMBINATION
	@GetMapping("/by-combination")
	public List<CourseModule> getModules(
			
			@RequestParam Combination combination,
			
			@RequestParam int level
	) {
		
		return service.getModulesByCombination(
				combination,
				level
		);
	}
	
	@GetMapping("/department/{department}")
	public List<CourseModule> getModulesByDepartment(
			
			@PathVariable Department department
	) {
		
		return service.getModulesByDepartment(
				department
		);
	}
}
