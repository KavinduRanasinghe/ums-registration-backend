package lk.ac.wusl.fas.ums_registration_backend.application.service.module;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

import java.util.List;

import lk.ac.wusl.fas.ums_registration_backend.domain.entity.RegisteredModule;

import lk.ac.wusl.fas.ums_registration_backend.domain.entity.Student;

import lk.ac.wusl.fas.ums_registration_backend.domain.repository.RegisteredModuleRepository;

import lk.ac.wusl.fas.ums_registration_backend.domain.repository.StudentRepository;

@Service
@RequiredArgsConstructor
public class RegisteredModuleService {
	
	private final RegisteredModuleRepository repository;
	
	private final StudentRepository studentRepository;
	
	// =====================================
	// GET BY STUDENT REG NO
	// =====================================
	
	public List<RegisteredModule> getByStudent(
			String regNo
	) {
		
		Student student =
				studentRepository.findByRegNo(
						regNo
				).orElseThrow(() ->
						
						new RuntimeException(
								"Student not found"
						)
				);
		
		return repository.findByStudentId(
				student.getId()
		);
	}
}
