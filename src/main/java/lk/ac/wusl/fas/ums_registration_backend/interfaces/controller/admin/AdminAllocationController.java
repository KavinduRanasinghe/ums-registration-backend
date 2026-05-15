package lk.ac.wusl.fas.ums_registration_backend.interfaces.controller.admin;

import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.*;

import java.util.List;

import lk.ac.wusl.fas.ums_registration_backend.application.service.allocation.AllocationService;

import lk.ac.wusl.fas.ums_registration_backend.domain.entity.CombinationCapacity;

import lk.ac.wusl.fas.ums_registration_backend.domain.enums.Combination;

import lk.ac.wusl.fas.ums_registration_backend.domain.repository.CombinationCapacityRepository;

@RestController
@RequestMapping("/api/allocation")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class AdminAllocationController {
	
	private final AllocationService service;
	
	private final CombinationCapacityRepository capacityRepository;
	
	// =====================================
	// RUN ALLOCATION
	// =====================================
	
	@PostMapping
	public String runAllocation() {
		
		service.allocate();
		
		return "Allocation completed successfully";
	}
	
	// =====================================
	// GET ALL CAPACITIES
	// =====================================
	
	@GetMapping("/capacities")
	public List<CombinationCapacity> getCapacities() {
		
		return capacityRepository.findAll();
	}
	
	// =====================================
	// UPDATE CAPACITY
	// =====================================
	
	@PutMapping("/capacity/{combination}")
	public CombinationCapacity updateCapacity(
			
			@PathVariable Combination combination,
			
			@RequestParam Integer capacity
	) {
		
		CombinationCapacity existing =
				
				capacityRepository
						
						.findByCombination(combination)
						
						.orElseThrow(() ->
								
								new RuntimeException(
										"Combination not found"
								)
						);
		
		existing.setCapacity(capacity);
		
		return capacityRepository.save(existing);
	}
	
	@DeleteMapping("/reset")
	public String resetAllocation() {
		
		service.resetAllocation();
		
		return "Allocation reset successfully";
	}
}
