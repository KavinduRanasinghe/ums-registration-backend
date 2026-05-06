package lk.ac.wusl.fas.ums_registration_backend.interfaces.controller.module;

import lk.ac.wusl.fas.ums_registration_backend.application.service.allocation.CourseModuleService;
import lk.ac.wusl.fas.ums_registration_backend.domain.entity.CourseModule;
import lk.ac.wusl.fas.ums_registration_backend.domain.enums.Combination;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/modules")
@RequiredArgsConstructor
public class CourseModuleController {
	
	private final CourseModuleService service;
	
	@GetMapping("/by-combination")
	public List<CourseModule> getModules(
			@RequestParam Combination combination,
			@RequestParam int level) {
		
		return service.getModulesByCombination(combination, level);
	}
}
