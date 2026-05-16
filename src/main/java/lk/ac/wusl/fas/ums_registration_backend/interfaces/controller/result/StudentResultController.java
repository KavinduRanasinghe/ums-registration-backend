package lk.ac.wusl.fas.ums_registration_backend.interfaces.controller.result;

import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.*;

import java.util.List;

import lk.ac.wusl.fas.ums_registration_backend.domain.entity.StudentResult;

import lk.ac.wusl.fas.ums_registration_backend.application.service.result.StudentResultService;

@RestController
@RequestMapping("/api/results")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class StudentResultController {
	
	private final StudentResultService service;
	
	// =====================================
	// SAVE RESULT
	// =====================================
	
	@PostMapping
	
	public StudentResult save(
			
			@RequestBody StudentResult result
	) {
		
		return service.save(
				result
		);
	}
	
	// =====================================
	// GET RESULTS BY STUDENT
	// =====================================
	
	@GetMapping("/{regNo}")
	
	public List<StudentResult> getByStudent(
			
			@PathVariable String regNo
	) {
		
		return service.getByStudent(
				regNo
		);
	}
}
