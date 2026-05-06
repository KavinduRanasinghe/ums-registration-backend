package lk.ac.wusl.fas.ums_registration_backend.application.dto.course;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RegisteredModuleViewDTO {
	
	private String code;
	
	private String name;
	
	private int credits;
	
	private String department;
}
