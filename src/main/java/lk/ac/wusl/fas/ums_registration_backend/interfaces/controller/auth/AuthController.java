package lk.ac.wusl.fas.ums_registration_backend.interfaces.controller.auth;

import lk.ac.wusl.fas.ums_registration_backend.application.dto.auth.*;
import lk.ac.wusl.fas.ums_registration_backend.application.service.auth.AuthService;

import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
@CrossOrigin
public class AuthController {
	
	private final AuthService authService;
	
	@PostMapping("/login")
	public LoginResponseDTO login(
			@RequestBody LoginRequestDTO dto
	) {
		
		return authService.login(dto);
	}
}
