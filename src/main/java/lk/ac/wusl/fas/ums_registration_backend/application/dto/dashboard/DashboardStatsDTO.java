package lk.ac.wusl.fas.ums_registration_backend.application.dto.dashboard;

import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DashboardStatsDTO {
	
	private long totalStudents;
	
	private long allocatedStudents;
	
	private long unallocatedStudents;
	
	private long pendingApprovals;
	
	private double highestZScore;
	
	private double lowestZScore;
	
	private double averageZScore;
	
	private List<CombinationStatsDTO> combinationStats;
}
