package lk.ac.wusl.fas.ums_registration_backend.interfaces.controller.module;

import lk.ac.wusl.fas.ums_registration_backend.application.dto.course.CourseRegistrationDTO;
import lk.ac.wusl.fas.ums_registration_backend.application.dto.course.RegisteredModuleViewDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import lk.ac.wusl.fas.ums_registration_backend.application.service.course.CourseRegistrationService;
import lk.ac.wusl.fas.ums_registration_backend.domain.entity.CourseRegistration;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/course-registration")
@CrossOrigin(origins = "*")
@RequiredArgsConstructor
public class CourseRegistrationController {
	
	private final CourseRegistrationService service;
	
	// 🔹 Student registration
	@PostMapping
	public CourseRegistration register(@RequestBody CourseRegistrationDTO dto) {
		return service.register(dto);
	}
	
	// 🔹 Get all (Admin)
	@GetMapping
	public List<CourseRegistration> getAll() {
		return service.getAll();
	}
	
	// ✅ Approve
	@PutMapping("/{id}/approve")
	public CourseRegistration approve(@PathVariable UUID id) {
		return service.approve(id);
	}
	
	// ❌ Reject
	@PutMapping("/{id}/reject")
	public CourseRegistration reject(@PathVariable UUID id) {
		return service.reject(id);
	}
	
	@GetMapping("/{id}/modules")
	public List<RegisteredModuleViewDTO> getModules(
			@PathVariable UUID id
	) {
		
		return service.getRegisteredModules(id);
	}
	
	
}
