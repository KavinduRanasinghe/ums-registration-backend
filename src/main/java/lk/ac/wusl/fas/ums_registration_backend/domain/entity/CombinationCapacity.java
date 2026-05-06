package lk.ac.wusl.fas.ums_registration_backend.domain.entity;

import jakarta.persistence.*;
import lombok.*;

import lk.ac.wusl.fas.ums_registration_backend.domain.enums.Combination;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CombinationCapacity {
	
	@Id
	@Enumerated(EnumType.STRING)
	private Combination combination;
	
	private int capacity;
}
