package lk.ac.wusl.fas.ums_registration_backend.interfaces.controller.lecturer;

import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.*;

import java.util.List;

import jakarta.validation.Valid;

import lk.ac.wusl.fas.ums_registration_backend.domain.entity.Lecturer;

import lk.ac.wusl.fas.ums_registration_backend.application.dto.lecturer.LecturerRegistrationDTO;

import lk.ac.wusl.fas.ums_registration_backend.application.service.lecturer.LecturerService;

@RestController
@RequestMapping("/api/lecturers")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class LecturerController {
	
	private final LecturerService lecturerService;
	
	@PostMapping
	public Lecturer register(
			
			@Valid
			@RequestBody
			LecturerRegistrationDTO dto
	) {
		
		return lecturerService.register(dto);
	}
	
	@GetMapping
	public List<Lecturer> getAllLecturers() {
		
		return lecturerService.getAllLecturers();
	}
	
	@GetMapping("/{lecturerId}")
	public Lecturer getLecturerById(
			
			@PathVariable String lecturerId
	) {
		
		return lecturerService
				.getLecturerById(
						lecturerId
				);
	}
}
