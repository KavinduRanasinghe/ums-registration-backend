package lk.ac.wusl.fas.ums_registration_backend.domain.entity;

import jakarta.persistence.*;

import lombok.*;

import java.util.UUID;

@Entity
@Table(name = "lecturers")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Lecturer {
	
	@Id
	@GeneratedValue
	private UUID id;
	
	@Column(unique = true)
	private String lecturerId;
	
	private String fullName;
	
	private String initials;
	
	private String gender;
	
	@Column(unique = true)
	private String email;
	
	private String mobile;
	
	private String department;
	
	private String designation;
	
	private String qualification;
	
	private Boolean active;
}
