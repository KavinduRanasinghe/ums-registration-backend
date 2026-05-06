package lk.ac.wusl.fas.ums_registration_backend.application.dto.course;

import lombok.Data;

import java.util.List;

@Data
public class CourseRegistrationDTO {
	
	private String regNo;
	private List<String> moduleCodes;
}
