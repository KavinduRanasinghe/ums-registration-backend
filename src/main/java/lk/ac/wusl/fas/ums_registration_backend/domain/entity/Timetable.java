package lk.ac.wusl.fas.ums_registration_backend.domain.entity;

import jakarta.persistence.*;

import lombok.*;

import java.time.LocalTime;
import java.util.UUID;

@Entity
@Table(name = "timetable")

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Timetable {
	
	@Id
	@GeneratedValue
	private UUID id;
	
	private String combination;
	
	private String moduleCode;
	
	private String moduleName;
	
	private String lecturerId;
	
	private String lecturerName;
	
	private String day;
	
	private LocalTime startTime;
	
	private LocalTime endTime;
	
	private String venue;
}
