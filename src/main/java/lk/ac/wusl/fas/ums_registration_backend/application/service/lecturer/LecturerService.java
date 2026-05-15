package lk.ac.wusl.fas.ums_registration_backend.application.service.lecturer;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

import java.util.List;

import lk.ac.wusl.fas.ums_registration_backend.domain.entity.Lecturer;

import lk.ac.wusl.fas.ums_registration_backend.domain.repository.LecturerRepository;

import lk.ac.wusl.fas.ums_registration_backend.application.dto.lecturer.LecturerRegistrationDTO;

@Service
@RequiredArgsConstructor
public class LecturerService {
	
	private final LecturerRepository lecturerRepository;
	
	public Lecturer register(
			LecturerRegistrationDTO dto
	) {
		
		lecturerRepository
				.findByLecturerId(dto.getLecturerId())
				.ifPresent(l -> {
					
					throw new RuntimeException(
							"Lecturer already exists"
					);
				});
		
		Lecturer lecturer = Lecturer.builder()
				
				.lecturerId(dto.getLecturerId())
				
				.fullName(dto.getFullName())
				
				.initials(dto.getInitials())
				
				.gender(dto.getGender())
				
				.email(dto.getEmail())
				
				.mobile(dto.getMobile())
				
				.department(dto.getDepartment())
				
				.designation(dto.getDesignation())
				
				.qualification(dto.getQualification())
				
				.active(true)
				
				.build();
		
		return lecturerRepository.save(lecturer);
	}
	
	public List<Lecturer> getAllLecturers() {
		
		return lecturerRepository.findAll();
	}
	
	public Lecturer getLecturerById(
			String lecturerId
	) {
		
		return lecturerRepository
				
				.findByLecturerId(lecturerId)
				
				.orElseThrow(() ->
						
						new RuntimeException(
								"Lecturer not found"
						)
				);
	}
}
