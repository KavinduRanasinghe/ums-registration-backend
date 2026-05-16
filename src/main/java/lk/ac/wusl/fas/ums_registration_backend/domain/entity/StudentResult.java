package lk.ac.wusl.fas.ums_registration_backend.domain.entity;

import jakarta.persistence.*;

import lombok.*;

import java.util.UUID;

@Entity
@Table(name = "student_results")

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StudentResult {
	
	@Id
	@GeneratedValue
	private UUID id;
	
	private UUID studentId;
	
	private String regNo;
	
	private String studentName;
	
	private String moduleCode;
	
	private String moduleName;
	
	private Integer credits;
	
	private String grade;
	
	private Double gpaPoint;
	
	private Integer semester;
	
	private String academicYear;
}
