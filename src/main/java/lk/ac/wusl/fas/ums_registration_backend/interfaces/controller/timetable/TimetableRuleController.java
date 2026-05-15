package lk.ac.wusl.fas.ums_registration_backend.interfaces.controller.timetable;

import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.*;

import java.util.List;

import lk.ac.wusl.fas.ums_registration_backend.domain.entity.TimetableRule;

import lk.ac.wusl.fas.ums_registration_backend.application.service.timetable.TimetableRuleService;

@RestController
@RequestMapping("/api/timetable-rules")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class TimetableRuleController {
	
	private final TimetableRuleService service;
	
	// GET ALL
	
	@GetMapping
	public List<TimetableRule> getAll() {
		
		return service.getAll();
	}
	
	// SAVE RULE
	
	@PostMapping
	public TimetableRule save(
			
			@RequestBody TimetableRule rule
	) {
		
		return service.save(rule);
	}
	
	// DELETE RULE
	
	@DeleteMapping("/{id}")
	public void delete(
			
			@PathVariable String id
	) {
		
		service.delete(id);
	}
}
