package lk.ac.wusl.fas.ums_registration_backend.domain.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

import lk.ac.wusl.fas.ums_registration_backend.domain.enums.Combination;

@Entity
@Table(name = "path_registration")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PathRegistration {
	
	@Id
	@GeneratedValue
	private UUID id;
	
	private String regNo;
	
	@Enumerated(EnumType.STRING)
	private Combination preference1;
	
	@Enumerated(EnumType.STRING)
	private Combination preference2;
	
	@Enumerated(EnumType.STRING)
	private Combination preference3;
}
