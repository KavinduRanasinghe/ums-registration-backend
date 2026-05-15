package lk.ac.wusl.fas.ums_registration_backend.domain.entity;

import jakarta.persistence.*;
import lk.ac.wusl.fas.ums_registration_backend.domain.enums.RegistrationStatus;
import lombok.*;

import java.util.UUID;

@Entity
@Table(name = "course_registrations")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CourseRegistration {
	
	@Id
	@GeneratedValue
	private UUID id;
	
	private UUID studentId;
	
	private int totalCredits;
	
	@Enumerated(EnumType.STRING)
	private RegistrationStatus status;
}
