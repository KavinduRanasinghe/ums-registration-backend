package lk.ac.wusl.fas.ums_registration_backend.application.service.attendance;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import lk.ac.wusl.fas.ums_registration_backend.domain.entity.AttendanceSession;

import lk.ac.wusl.fas.ums_registration_backend.domain.entity.AttendanceRecord;

import lk.ac.wusl.fas.ums_registration_backend.domain.repository.AttendanceSessionRepository;

import lk.ac.wusl.fas.ums_registration_backend.domain.repository.AttendanceRecordRepository;

@Service
@RequiredArgsConstructor
public class AttendanceService {
	
	private final AttendanceSessionRepository
			sessionRepository;
	
	private final AttendanceRecordRepository
			recordRepository;
	
	// =====================================
	// START SESSION
	// =====================================
	
	public AttendanceSession startSession(
			
			AttendanceSession session
	) {
		
		session.setSessionCode(
				UUID.randomUUID()
						.toString()
						.substring(0, 8)
		);
		
		session.setDate(
				LocalDate.now()
		);
		
		session.setStartTime(
				LocalDateTime.now()
		);
		
		session.setActive(true);
		
		return sessionRepository.save(
				session
		);
	}
	
	// =====================================
	// END SESSION
	// =====================================
	
	public AttendanceSession endSession(
			String sessionCode
	) {
		
		AttendanceSession session =
				sessionRepository
						.findBySessionCodeAndActiveTrue(
								sessionCode
						)
						.orElseThrow();
		
		session.setActive(false);
		
		return sessionRepository.save(
				session
		);
	}
	
	// =====================================
	// MARK ATTENDANCE
	// =====================================
	
	public AttendanceRecord markAttendance(
			
			AttendanceRecord record
	) {
		
		// DUPLICATE CHECK
		
		boolean alreadyMarked =
				
				recordRepository
						.existsBySessionCodeAndRegNo(
								
								record.getSessionCode(),
								
								record.getRegNo()
						);
		
		if (alreadyMarked) {
			
			throw new RuntimeException(
					"Attendance already marked"
			);
		}
		
		AttendanceSession session =
				
				sessionRepository
						.findBySessionCodeAndActiveTrue(
								
								record.getSessionCode()
						)
						.orElseThrow(() ->
								
								new RuntimeException(
										"Session expired"
								)
						);
		
		record.setModuleCode(
				session.getModuleCode()
		);
		
		record.setModuleName(
				session.getModuleName()
		);
		
		record.setStatus("PRESENT");
		
		record.setScannedAt(
				LocalDateTime.now()
		);
		
		return recordRepository.save(
				record
		);
	}
	
	// =====================================
	// GET ATTENDANCE
	// =====================================
	
	public List<AttendanceRecord> getAttendance(
			String sessionCode
	) {
		
		return recordRepository
				.findBySessionCode(
						sessionCode
				);
	}
}
