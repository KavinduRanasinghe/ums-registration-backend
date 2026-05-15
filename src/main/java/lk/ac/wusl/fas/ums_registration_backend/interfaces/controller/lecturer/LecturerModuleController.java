package lk.ac.wusl.fas.ums_registration_backend.interfaces.controller.lecturer;

import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

import lk.ac.wusl.fas.ums_registration_backend.domain.entity.LecturerModule;

import lk.ac.wusl.fas.ums_registration_backend.application.dto.lecturer.LecturerModuleDTO;

import lk.ac.wusl.fas.ums_registration_backend.application.service.lecturer.LecturerModuleService;

@RestController
@RequestMapping("/api/lecturer-modules")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class LecturerModuleController {
	
	private final LecturerModuleService service;
	
	@PostMapping
	public LecturerModule assign(
			@RequestBody LecturerModuleDTO dto
	) {
		
		return service.assign(dto);
	}
	
	@GetMapping
	public List<LecturerModule> getAll() {
		
		return service.getAll();
	}
	
	@GetMapping("/{lecturerId}")
	public List<LecturerModule> getByLecturer(
			
			@PathVariable String lecturerId
	) {
		
		return service.getByLecturer(
				lecturerId
		);
	}
	
	@DeleteMapping("/{id}")
	public void deleteAssignment(
			
			@PathVariable UUID id
	) {
		
		service.delete(id);
	}
	
	@PutMapping("/{id}")
	public LecturerModule updateAssignment(
			
			@PathVariable UUID id,
			
			@RequestBody LecturerModuleDTO dto
	) {
		
		return service.update(id, dto);
	}
}
