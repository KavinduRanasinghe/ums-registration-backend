package lk.ac.wusl.fas.ums_registration_backend.interfaces.controller.timetable;

import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.*;

import java.util.List;

import lk.ac.wusl.fas.ums_registration_backend.domain.entity.Timetable;

import lk.ac.wusl.fas.ums_registration_backend.application.service.timetable.TimetableService;

@RestController
@RequestMapping("/api/timetable")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class TimetableController {
	
	private final TimetableService service;
	
	// =====================================
	// GENERATE TIMETABLE
	// =====================================
	
	@PostMapping("/generate")
	
	public List<Timetable> generate() {
		
		return service.generate();
	}
	
	// =====================================
	// GET ALL TIMETABLES
	// =====================================
	
	@GetMapping
	
	public List<Timetable> getAll() {
		
		return service.getAll();
	}
}
