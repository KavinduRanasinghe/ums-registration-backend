package lk.ac.wusl.fas.ums_registration_backend.domain.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {
	
	@Id
	@GeneratedValue
	private UUID id;
	
	private String username;
	
	private String password;
	
	private String role;
}
