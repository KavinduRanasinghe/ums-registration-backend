package lk.ac.wusl.fas.ums_registration_backend.interfaces.controller.module;

import lk.ac.wusl.fas.ums_registration_backend.application.service.allocation.CourseModuleService;
import lk.ac.wusl.fas.ums_registration_backend.domain.entity.CourseModule;
import lk.ac.wusl.fas.ums_registration_backend.domain.enums.Combination;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/modules")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class CourseModuleController {
	
	private final CourseModuleService service;
	
	@GetMapping("/by-combination")
	public List<CourseModule> getModules(
			@RequestParam Combination combination,
			@RequestParam int level) {
		
		return service.getModulesByCombination(combination, level);
	}
	
	// =========================
	// GET ALL MODULES
	// =========================
	@GetMapping
	public List<CourseModule> getAllModules() {
		
		return service.getAllModules();
	}
	
	// =========================
	// ADD MODULE
	// =========================
	@PostMapping
	public CourseModule addModule(
			@RequestBody CourseModule module
	) {
		
		return service.addModule(module);
	}
	
	// =========================
	// DELETE MODULE
	// =========================
	@DeleteMapping("/{code}")
	public void deleteModule(
			@PathVariable String code
	) {
		
		service.deleteModule(code);
	}
}
