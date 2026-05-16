package lk.ac.wusl.fas.ums_registration_backend.interfaces.controller.module;

import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.*;

import java.util.List;

import lk.ac.wusl.fas.ums_registration_backend.domain.entity.RegisteredModule;

import lk.ac.wusl.fas.ums_registration_backend.application.service.module.RegisteredModuleService;

@RestController
@RequestMapping("/api/registered-modules")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class RegisteredModuleController {
	
	private final RegisteredModuleService service;
	
	// =====================================
	// GET REGISTERED MODULES BY STUDENT
	// =====================================
	
	@GetMapping("/student/{regNo}")
	
	public List<RegisteredModule> getByStudent(
			
			@PathVariable String regNo
	) {
		
		return service.getByStudent(
				regNo
		);
	}
}
