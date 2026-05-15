package lk.ac.wusl.fas.ums_registration_backend.application.dto.dashboard;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CombinationStatsDTO {
	
	private String name;
	
	private long value;
	
	private long capacity;
}
