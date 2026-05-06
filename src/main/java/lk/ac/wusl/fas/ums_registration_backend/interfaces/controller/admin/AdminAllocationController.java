package lk.ac.wusl.fas.ums_registration_backend.interfaces.controller.admin;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import lk.ac.wusl.fas.ums_registration_backend.application.service.allocation.AllocationService;

@RestController
@RequestMapping("/api/allocation")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class AdminAllocationController {
	
	private final AllocationService service;
	
	@PostMapping
	public String runAllocation() {
		service.allocate();
		return "Allocation completed successfully";
	}
}
