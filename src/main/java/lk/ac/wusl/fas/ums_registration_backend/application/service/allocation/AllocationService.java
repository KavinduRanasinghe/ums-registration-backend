package lk.ac.wusl.fas.ums_registration_backend.application.service.allocation;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.*;

import lk.ac.wusl.fas.ums_registration_backend.domain.entity.*;
import lk.ac.wusl.fas.ums_registration_backend.domain.enums.Combination;
import lk.ac.wusl.fas.ums_registration_backend.domain.repository.*;


@Service
@RequiredArgsConstructor
public class AllocationService {
	
	private final StudentRepository studentRepository;
	private final PathRegistrationRepository pathRepository;
	private final CombinationCapacityRepository capacityRepository;
	private final AllocationLogRepository allocationLogRepository;
	
	@Transactional
	public void allocate() {
		
		List<Student> students = studentRepository.findAll();
		
		// 🔥 Sort by Z-score DESC
		students.sort((a, b) -> Double.compare(b.getZScore(), a.getZScore()));
		
		Map<Combination, Integer> remaining = new HashMap<>();
		
		// Load capacities
		for (CombinationCapacity c : capacityRepository.findAll()) {
			remaining.put(c.getCombination(), c.getCapacity());
		}
		
		for (Student student : students) {
			
			PathRegistration path =
					pathRepository.findByRegNo(
							student.getRegNo()
					).orElse(null);
			
			if (path == null) continue;
			
			Combination assigned = assign(path, remaining);
			
			student.setAssignedCombination(assigned);
			studentRepository.save(student);
		}
		
		AllocationLog log =
				AllocationLog.builder()
						
						.executedAt(
								LocalDateTime.now()
						)
						
						.totalStudents(
								students.size()
						)
						
						.allocatedStudents(
								(int) students.stream()
										
										.filter(s ->
												s.getAssignedCombination()
														!= null
										)
										
										.count()
						)
						
						.unallocatedStudents(
								(int) students.stream()
										
										.filter(s ->
												s.getAssignedCombination()
														== null
										)
										
										.count()
						)
						
						.build();
		
		
		allocationLogRepository.save(log);
	}
	
	
	
	@Transactional
	public void resetAllocation() {
		
		List<Student> students =
				studentRepository.findAll();
		
		for (Student student : students) {
			
			student.setAssignedCombination(null);
			
			studentRepository.save(student);
		}
	}
	
	
	
	private Combination assign(PathRegistration path, Map<Combination, Integer> remaining) {
		
		List<Combination> prefs = List.of(
				path.getPreference1(),
				path.getPreference2(),
				path.getPreference3()
		);
		
		for (Combination pref : prefs) {
			
			if (remaining.getOrDefault(pref, 0) > 0) {
				remaining.put(pref, remaining.get(pref) - 1);
				return pref;
			}
		}
		
		return null; // no capacity left
	}
	
	
}
