package lk.ac.wusl.fas.ums_registration_backend.application.dto.lecturer;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LecturerModuleDTO {
	
	private String lecturerId;
	
	private String moduleCode;
	
	private String moduleName;
}
