package lk.ac.wusl.fas.ums_registration_backend.domain.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;
import lk.ac.wusl.fas.ums_registration_backend.domain.enums.Combination;

@Entity
@Table(name = "students")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Student {
	
	@Id
	@GeneratedValue
	private UUID id;
	
	@Column(nullable = false, unique = true)
	private String regNo;
	
	private String name;
	private String initials;
	private String gender;
	private String district;
	
	@Column(name = "z_score")
	private Double zScore;
	
	private Integer level;
	
	@Column(name = "preference_1")
	@Enumerated(EnumType.STRING)
	private Combination preference1;
	
	@Column(name = "preference_2")
	@Enumerated(EnumType.STRING)
	private Combination preference2;
	
	@Column(name = "preference_3")
	@Enumerated(EnumType.STRING)
	private Combination preference3;
	
	@Enumerated(EnumType.STRING)
	private Combination assignedCombination;
}
