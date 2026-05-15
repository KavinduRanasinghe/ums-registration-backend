package lk.ac.wusl.fas.ums_registration_backend.application.service.dashboard;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

import java.util.List;

import lk.ac.wusl.fas.ums_registration_backend.application.dto.dashboard.*;

import lk.ac.wusl.fas.ums_registration_backend.domain.entity.*;

import lk.ac.wusl.fas.ums_registration_backend.domain.enums.Combination;

import lk.ac.wusl.fas.ums_registration_backend.domain.repository.*;

@Service
@RequiredArgsConstructor
public class DashboardService {
	
	private final StudentRepository studentRepository;
	
	private final CombinationCapacityRepository capacityRepository;
	
	public DashboardStatsDTO getStats() {
		
		List<Student> students =
				studentRepository.findAll();
		
		long totalStudents =
				students.size();
		
		long allocatedStudents =
				students.stream()
						.filter(s ->
								s.getAssignedCombination()
										!= null
						)
						.count();
		
		long unallocatedStudents =
				totalStudents - allocatedStudents;
		
		double highestZScore =
				students.stream()
						.mapToDouble(Student::getZScore)
						.max()
						.orElse(0);
		
		double lowestZScore =
				students.stream()
						.mapToDouble(Student::getZScore)
						.min()
						.orElse(0);
		
		double averageZScore =
				students.stream()
						.mapToDouble(Student::getZScore)
						.average()
						.orElse(0);
		
		List<CombinationStatsDTO> combinationStats =
				List.of(
						
						buildCombinationStats(
								Combination.COMB1,
								students
						),
						
						buildCombinationStats(
								Combination.COMB2,
								students
						),
						
						buildCombinationStats(
								Combination.COMB3,
								students
						)
				);
		
		return DashboardStatsDTO.builder()
				
				.totalStudents(totalStudents)
				
				.allocatedStudents(allocatedStudents)
				
				.unallocatedStudents(unallocatedStudents)
				
				.pendingApprovals(0)
				
				.highestZScore(highestZScore)
				
				.lowestZScore(lowestZScore)
				
				.averageZScore(
						Math.round(
								averageZScore * 100.0
						) / 100.0
				)
				
				.combinationStats(combinationStats)
				
				.build();
	}
	
	private CombinationStatsDTO buildCombinationStats(
			
			Combination combination,
			
			List<Student> students
	) {
		
		long allocated =
				students.stream()
						
						.filter(s ->
								combination.equals(
										s.getAssignedCombination()
								)
						)
						
						.count();
		
		CombinationCapacity capacity =
				capacityRepository
						.findByCombination(combination)
						.orElse(null);
		
		long maxCapacity =
				capacity != null
						? capacity.getCapacity()
						: 0;
		
		return CombinationStatsDTO.builder()
				
				.name(combination.name())
				
				.value(allocated)
				
				.capacity(maxCapacity)
				
				.build();
	}
}
