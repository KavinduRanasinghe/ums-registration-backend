package lk.ac.wusl.fas.ums_registration_backend.application.service.student;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import lk.ac.wusl.fas.ums_registration_backend.domain.entity.*;
import lk.ac.wusl.fas.ums_registration_backend.domain.repository.*;
import lk.ac.wusl.fas.ums_registration_backend.application.dto.student.StudentRegistrationDTO;
import lk.ac.wusl.fas.ums_registration_backend.interfaces.exception.BadRequestException;

@Service
@RequiredArgsConstructor
public class StudentRegistrationService {
	
	private final StudentRepository studentRepository;
	private final PathRegistrationRepository pathRepository;
	
	@Transactional
	public Student register(StudentRegistrationDTO dto) {
		
		validatePreferences(dto);
		
		// Duplicate check
		studentRepository.findByRegNo(dto.getRegNo())
				.ifPresent(s -> {
					throw new BadRequestException("Student already registered");
				});
		
		// Save student
		Student student = Student.builder()
				.regNo(dto.getRegNo())
				.name(dto.getName())
				.initials(dto.getInitials())
				.gender(dto.getGender())
				.district(dto.getDistrict())
				.zScore(dto.getZScore())
				.level(dto.getLevel())
				.preference1(dto.getPreference1())
				.preference2(dto.getPreference2())
				.preference3(dto.getPreference3())
				.assignedCombination(null)
				.build();
		
		student = studentRepository.save(student);
		
		// 🔥 Save preferences
		PathRegistration path = new PathRegistration();
		path.setRegNo(student.getRegNo());
		path.setPreference1(student.getPreference1());
		path.setPreference2(student.getPreference2());
		path.setPreference3(student.getPreference3());
		
		pathRepository.save(path);
		
		return student;
	}
	
	public List<Student> getAllStudents() {
		return studentRepository.findAll();
	}
	
	private void validatePreferences(StudentRegistrationDTO dto) {
		if (dto.getPreference1().equals(dto.getPreference2()) ||
				dto.getPreference1().equals(dto.getPreference3()) ||
				dto.getPreference2().equals(dto.getPreference3())) {
			throw new BadRequestException("Preferences must be unique");
		}
	}
	
	public Student getStudentByRegNo(String regNo) {
		
		return studentRepository.findByRegNo(regNo)
				.orElseThrow(() ->
						new RuntimeException("Student not found"));
	}
}
