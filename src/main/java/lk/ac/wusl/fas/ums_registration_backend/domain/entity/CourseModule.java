package lk.ac.wusl.fas.ums_registration_backend.domain.entity;

import lk.ac.wusl.fas.ums_registration_backend.domain.enums.Department;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "modules")
@Getter
@Setter
public class CourseModule {
	
	@Id
	private String code;
	
	private String name;
	private int credits;
	private int level;
	private int semester;
	
	@Enumerated(EnumType.STRING)
	private Department department;
	
	private boolean compulsory;
}
