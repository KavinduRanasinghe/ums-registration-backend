package lk.ac.wusl.fas.ums_registration_backend.interfaces.controller.hall;

import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.*;

import java.util.List;

import lk.ac.wusl.fas.ums_registration_backend.domain.entity.Hall;

import lk.ac.wusl.fas.ums_registration_backend.application.service.hall.HallService;

@RestController
@RequestMapping("/api/halls")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class HallController {
	
	private final HallService service;
	
	// GET ALL
	
	@GetMapping
	public List<Hall> getAll() {
		
		return service.getAll();
	}
	
	// SAVE
	
	@PostMapping
	public Hall save(
			
			@RequestBody Hall hall
	) {
		
		return service.save(hall);
	}
	
	// DELETE
	
	@DeleteMapping("/{id}")
	public void delete(
			
			@PathVariable String id
	) {
		
		service.delete(id);
	}
	
	// UPDATE CAPACITY
	
	@PutMapping("/{id}/capacity")
	
	public Hall updateCapacity(
			
			@PathVariable String id,
			
			@RequestParam Integer capacity
	) {
		
		return service.updateCapacity(
				id,
				capacity
		);
	}
}
