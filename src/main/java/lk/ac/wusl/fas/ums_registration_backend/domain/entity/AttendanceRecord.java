package lk.ac.wusl.fas.ums_registration_backend.domain.entity;

import jakarta.persistence.*;

import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "attendance_records")

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AttendanceRecord {
	
	@Id
	@GeneratedValue
	private UUID id;
	
	private String sessionCode;
	
	private String regNo;
	
	private String studentName;
	
	private String moduleCode;
	
	private String moduleName;
	
	private String status;
	
	private LocalDateTime scannedAt;
}
