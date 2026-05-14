package lk.ac.wusl.fas.ums_registration_backend.application.dto.auth;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginRequestDTO {
	
	private String username;
	
	private String password;
}
