package lk.ac.wusl.fas.ums_registration_backend.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalTime;
import java.util.UUID;

import lk.ac.wusl.fas.ums_registration_backend.domain.entity.Timetable;

public interface TimetableRepository
		extends JpaRepository<Timetable, UUID> {
	
	boolean existsByLecturerIdAndDayAndStartTime(
			
			String lecturerId,
			
			String day,
			
			LocalTime startTime
	);
}
