package lk.ac.wusl.fas.ums_registration_backend.application.service.course;

import lk.ac.wusl.fas.ums_registration_backend.application.dto.course.CourseRegistrationDTO;
import lk.ac.wusl.fas.ums_registration_backend.application.dto.course.RegisteredModuleViewDTO;
import lk.ac.wusl.fas.ums_registration_backend.domain.entity.CourseModule;
import lk.ac.wusl.fas.ums_registration_backend.domain.entity.CourseRegistration;
import lk.ac.wusl.fas.ums_registration_backend.domain.entity.RegisteredModule;
import lk.ac.wusl.fas.ums_registration_backend.domain.entity.Student;
import lk.ac.wusl.fas.ums_registration_backend.domain.enums.Department;
import lk.ac.wusl.fas.ums_registration_backend.domain.enums.RegistrationStatus;
import lk.ac.wusl.fas.ums_registration_backend.domain.repository.CourseModuleRepository;
import lk.ac.wusl.fas.ums_registration_backend.domain.repository.CourseRegistrationRepository;
import lk.ac.wusl.fas.ums_registration_backend.domain.repository.RegisteredModuleRepository;
import lk.ac.wusl.fas.ums_registration_backend.domain.repository.StudentRepository;
import lk.ac.wusl.fas.ums_registration_backend.domain.util.CombinationMapping;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CourseRegistrationService {
	
	private final StudentRepository studentRepository;
	private final CourseModuleRepository moduleRepository;
	private final CourseRegistrationRepository registrationRepository;
	private final RegisteredModuleRepository registeredModuleRepository;
	
	public CourseRegistration register(CourseRegistrationDTO dto) {
		
		// 🔍 Find student
		Student student = studentRepository.findByRegNo(dto.getRegNo())
				.orElseThrow(() -> new RuntimeException("Student not found"));
		
		// ❌ Must be allocated
		if (student.getAssignedCombination() == null) {
			throw new RuntimeException("Student not allocated to a combination");
		}
		
		// ❌ Prevent duplicate registration
		if (registrationRepository.existsByStudentId(student.getId())) {
			throw new RuntimeException("Student already registered for courses");
		}
		
		// ✅ Get allowed departments
		List<Department> allowedDepartments =
				CombinationMapping.MAP.get(student.getAssignedCombination());
		
		int totalCredits = 0;
		
		// 🔁 Validate modules
		for (String code : dto.getModuleCodes()) {
			
			CourseModule module = moduleRepository.findById(code)
					.orElseThrow(() -> new RuntimeException("Module not found: " + code));
			
			// ❌ Validate department
			if (!allowedDepartments.contains(module.getDepartment())) {
				throw new RuntimeException(
						"Invalid module for combination: " + code);
			}
			
			totalCredits += module.getCredits();
		}
		
		// ❌ Credit validation
		if (totalCredits < 30 || totalCredits > 33) {
			throw new RuntimeException("Invalid credit count: " + totalCredits);
		}
		
		// 💾 Save registration
		CourseRegistration registration = new CourseRegistration();
		registration.setStudentId(student.getId());
		registration.setTotalCredits(totalCredits);
		registration.setStatus(RegistrationStatus.PENDING);
		
		registration = registrationRepository.save(registration);
		
		// 💾 Save selected modules
		for (String code : dto.getModuleCodes()) {
			RegisteredModule rm = new RegisteredModule();
			rm.setStudentId(student.getId());
			rm.setModuleCode(code);
			registeredModuleRepository.save(rm);
		}
		
		return registration;
	}
	
	// 📌 Optional: Get all registrations
	public List<CourseRegistration> getAll() {
		return registrationRepository.findAll();
	}
	
	// ✅ APPROVE
	public CourseRegistration approve(UUID id) {
		
		CourseRegistration registration = registrationRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Registration not found"));
		
		registration.setStatus(RegistrationStatus.APPROVED);
		
		return registrationRepository.save(registration);
	}
	
	// ❌ REJECT
	public CourseRegistration reject(UUID id) {
		
		CourseRegistration registration = registrationRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Registration not found"));
		
		registration.setStatus(RegistrationStatus.REJECTED);
		
		return registrationRepository.save(registration);
	}
	
	
	public List<RegisteredModuleViewDTO> getRegisteredModules(
			UUID registrationId
	) {
		
		CourseRegistration registration =
				registrationRepository.findById(registrationId)
						.orElseThrow(() ->
								new RuntimeException(
										"Registration not found"
								));
		
		List<RegisteredModule> registeredModules =
				registeredModuleRepository.findByStudentId(
						registration.getStudentId()
				);
		
		return registeredModules.stream().map(rm -> {
			
			CourseModule module =
					moduleRepository.findById(
							rm.getModuleCode()
					).orElseThrow();
			
			return RegisteredModuleViewDTO.builder()
					.code(module.getCode())
					.name(module.getName())
					.credits(module.getCredits())
					.department(
							module.getDepartment().name()
					)
					.build();
			
		}).toList();
	}
}
