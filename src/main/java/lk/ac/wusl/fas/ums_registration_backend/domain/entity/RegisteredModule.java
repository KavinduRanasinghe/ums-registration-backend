package lk.ac.wusl.fas.ums_registration_backend.domain.entity;

import jakarta.persistence.*;
import lombok.*;
import java.util.UUID;

@Entity
@Table(name = "registered_modules")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RegisteredModule {
	
	@Id
	@GeneratedValue
	private UUID id;
	
	private UUID studentId;
	
	private String moduleCode;
}
