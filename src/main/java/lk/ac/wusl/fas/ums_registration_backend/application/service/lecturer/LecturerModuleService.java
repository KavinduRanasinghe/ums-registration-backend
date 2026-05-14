package lk.ac.wusl.fas.ums_registration_backend.application.service.lecturer;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

import java.util.List;

import lk.ac.wusl.fas.ums_registration_backend.domain.entity.LecturerModule;

import lk.ac.wusl.fas.ums_registration_backend.domain.repository.LecturerModuleRepository;

import lk.ac.wusl.fas.ums_registration_backend.application.dto.lecturer.LecturerModuleDTO;

@Service
@RequiredArgsConstructor
public class LecturerModuleService {
	
	private final LecturerModuleRepository repository;
	
	public LecturerModule assign(
			LecturerModuleDTO dto
	) {
		
		LecturerModule assignment =
				LecturerModule.builder()
						
						.lecturerId(dto.getLecturerId())
						
						.moduleCode(dto.getModuleCode())
						
						.moduleName(dto.getModuleName())
						
						.build();
		
		return repository.save(assignment);
	}
	
	public List<LecturerModule> getAll() {
		
		return repository.findAll();
	}
	
	public List<LecturerModule> getByLecturer(
			String lecturerId
	) {
		
		return repository.findByLecturerId(
				lecturerId
		);
	}
}
