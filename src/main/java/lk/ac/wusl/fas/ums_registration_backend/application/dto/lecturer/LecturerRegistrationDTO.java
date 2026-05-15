package lk.ac.wusl.fas.ums_registration_backend.application.dto.lecturer;

import jakarta.validation.constraints.*;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LecturerRegistrationDTO {
	
	@NotBlank
	private String lecturerId;
	
	@NotBlank
	private String fullName;
	
	private String initials;
	
	@NotBlank
	private String gender;
	
	@Email
	private String email;
	
	private String mobile;
	
	private String department;
	
	private String designation;
	
	private String qualification;
}
