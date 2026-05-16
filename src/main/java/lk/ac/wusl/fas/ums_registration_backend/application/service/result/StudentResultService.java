package lk.ac.wusl.fas.ums_registration_backend.application.service.result;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

import java.util.List;

import lk.ac.wusl.fas.ums_registration_backend.domain.entity.StudentResult;

import lk.ac.wusl.fas.ums_registration_backend.domain.repository.StudentResultRepository;

@Service
@RequiredArgsConstructor
public class StudentResultService {
	
	private final StudentResultRepository repository;
	
	// =====================================
	// SAVE RESULT
	// =====================================
	
	public StudentResult save(
			StudentResult result
	) {
		
		// GPA POINT AUTO MAPPING
		
		switch (
				result.getGrade()
		) {
			
			case "A":
				result.setGpaPoint(4.0);
				break;
			
			case "A-":
				result.setGpaPoint(3.7);
				break;
			
			case "B+":
				result.setGpaPoint(3.3);
				break;
			
			case "B":
				result.setGpaPoint(3.0);
				break;
			
			case "B-":
				result.setGpaPoint(2.7);
				break;
			
			case "C+":
				result.setGpaPoint(2.3);
				break;
			
			case "C":
				result.setGpaPoint(2.0);
				break;
			
			case "C-":
				result.setGpaPoint(1.7);
				break;
			
			case "D":
				result.setGpaPoint(1.0);
				break;
			
			default:
				result.setGpaPoint(0.0);
		}
		
		return repository.save(result);
	}
	
	// =====================================
	// GET BY STUDENT
	// =====================================
	
	public List<StudentResult> getByStudent(
			String regNo
	) {
		
		return repository.findByRegNo(
				regNo
		);
	}
}
