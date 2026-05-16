package lk.ac.wusl.fas.ums_registration_backend.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

import lk.ac.wusl.fas.ums_registration_backend.domain.entity.AttendanceRecord;

public interface AttendanceRecordRepository
		extends JpaRepository<AttendanceRecord, UUID> {
	
	boolean existsBySessionCodeAndRegNo(
			
			String sessionCode,
			
			String regNo
	);
	
	List<AttendanceRecord>
	findBySessionCode(
			String sessionCode
	);
}
