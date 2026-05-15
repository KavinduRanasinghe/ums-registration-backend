package lk.ac.wusl.fas.ums_registration_backend.domain.entity;

import jakarta.persistence.*;

import lombok.*;

import java.time.LocalTime;
import java.util.UUID;

@Entity
@Table(name = "timetable_rules")

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TimetableRule {
	
	@Id
	@GeneratedValue
	private UUID id;
	
	private String workingDays;
	
	private LocalTime startTime;
	
	private LocalTime endTime;
	
	private Integer slotDuration;
	
	private LocalTime lunchStart;
	
	private LocalTime lunchEnd;
	
	private Integer maxLecturesPerDay;
	
	private Integer maxHoursPerLecturer;
}
