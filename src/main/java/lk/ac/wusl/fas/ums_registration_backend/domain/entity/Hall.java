package lk.ac.wusl.fas.ums_registration_backend.domain.entity;

import jakarta.persistence.*;

import lombok.*;

import java.util.UUID;

@Entity
@Table(name = "halls")

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Hall {
	
	@Id
	@GeneratedValue
	private UUID id;
	
	@Column(unique = true)
	private String hallCode;
	
	private String hallName;
	
	private Integer capacity;
	
	private String hallType;
	
	private Boolean active;
}
