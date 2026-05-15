package lk.ac.wusl.fas.ums_registration_backend.application.dto.auth;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class LoginResponseDTO {
	
	private String token;
	
	private String role;
}
