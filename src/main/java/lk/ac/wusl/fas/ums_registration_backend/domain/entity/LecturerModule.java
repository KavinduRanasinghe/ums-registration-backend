package lk.ac.wusl.fas.ums_registration_backend.domain.entity;

import jakarta.persistence.*;

import lombok.*;

import java.util.UUID;

@Entity
@Table(name = "lecturer_modules")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LecturerModule {
	
	@Id
	@GeneratedValue
	private UUID id;
	
	private String lecturerId;
	
	private String moduleCode;
	
	private String moduleName;
}
