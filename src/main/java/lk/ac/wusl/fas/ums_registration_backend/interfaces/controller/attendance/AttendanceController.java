package lk.ac.wusl.fas.ums_registration_backend.interfaces.controller.attendance;

import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.*;

import java.util.List;

import lk.ac.wusl.fas.ums_registration_backend.domain.entity.AttendanceSession;

import lk.ac.wusl.fas.ums_registration_backend.domain.entity.AttendanceRecord;

import lk.ac.wusl.fas.ums_registration_backend.application.service.attendance.AttendanceService;

@RestController
@RequestMapping("/api/attendance")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class AttendanceController {
	
	private final AttendanceService service;
	
	// =====================================
	// START SESSION
	// =====================================
	
	@PostMapping("/session/start")
	
	public AttendanceSession startSession(
			
			@RequestBody AttendanceSession session
	) {
		
		return service.startSession(
				session
		);
	}
	
	// =====================================
	// END SESSION
	// =====================================
	
	@PutMapping("/session/end/{sessionCode}")
	
	public AttendanceSession endSession(
			
			@PathVariable String sessionCode
	) {
		
		return service.endSession(
				sessionCode
		);
	}
	
	// =====================================
	// MARK ATTENDANCE
	// =====================================
	
	@PostMapping("/scan")
	
	public AttendanceRecord markAttendance(
			
			@RequestBody AttendanceRecord record
	) {
		
		return service.markAttendance(
				record
		);
	}
	
	// =====================================
	// GET ATTENDANCE
	// =====================================
	
	@GetMapping("/{sessionCode}")
	
	public List<AttendanceRecord> getAttendance(
			
			@PathVariable String sessionCode
	) {
		
		return service.getAttendance(
				sessionCode
		);
	}
}
