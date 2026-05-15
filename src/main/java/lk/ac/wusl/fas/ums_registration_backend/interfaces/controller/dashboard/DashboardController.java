package lk.ac.wusl.fas.ums_registration_backend.interfaces.controller.dashboard;

import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.*;

import lk.ac.wusl.fas.ums_registration_backend.application.dto.dashboard.DashboardStatsDTO;

import lk.ac.wusl.fas.ums_registration_backend.application.service.dashboard.DashboardService;

@RestController
@RequestMapping("/api/dashboard")
@RequiredArgsConstructor
@CrossOrigin
public class DashboardController {
	
	private final DashboardService dashboardService;
	
	@GetMapping("/stats")
	public DashboardStatsDTO getStats() {
		
		return dashboardService.getStats();
	}
}
