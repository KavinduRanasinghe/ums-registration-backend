package lk.ac.wusl.fas.ums_registration_backend.domain.entity;

import jakarta.persistence.*;

import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "attendance_sessions")

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AttendanceSession {
	
	@Id
	@GeneratedValue
	private UUID id;
	
	private String sessionCode;
	
	private String lecturerId;
	
	private String lecturerName;
	
	private String moduleCode;
	
	private String moduleName;
	
	private String hall;
	
	private LocalDate date;
	
	private LocalDateTime startTime;
	
	private Boolean active;
}
