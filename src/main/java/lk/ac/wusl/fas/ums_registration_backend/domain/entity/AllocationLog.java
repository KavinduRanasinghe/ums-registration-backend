package lk.ac.wusl.fas.ums_registration_backend.domain.entity;

import jakarta.persistence.*;

import lombok.*;

import java.time.LocalDateTime;

import java.util.UUID;

@Entity
@Table(name = "allocation_logs")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AllocationLog {
	
	@Id
	@GeneratedValue
	private UUID id;
	
	private LocalDateTime executedAt;
	
	private Integer totalStudents;
	
	private Integer allocatedStudents;
	
	private Integer unallocatedStudents;
}
