package lk.ac.wusl.fas.ums_registration_backend.application.service.auth;

import lk.ac.wusl.fas.ums_registration_backend.application.dto.auth.*;
import lk.ac.wusl.fas.ums_registration_backend.domain.entity.User;
import lk.ac.wusl.fas.ums_registration_backend.domain.repository.UserRepository;

import lombok.RequiredArgsConstructor;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {
	
	private final UserRepository userRepository;
	
	private final JwtService jwtService;
	
	private final PasswordEncoder passwordEncoder;
	
	public LoginResponseDTO login(
			LoginRequestDTO dto
	) {
		
		User user = userRepository
				.findByUsername(dto.getUsername())
				.orElseThrow(() ->
						new RuntimeException("Invalid username")
				);
		
		boolean valid =
				passwordEncoder.matches(
						dto.getPassword(),
						user.getPassword()
				);
		
		if (!valid) {
			
			throw new RuntimeException(
					"Invalid password"
			);
		}
		
		String token =
				jwtService.generateToken(
						user.getUsername()
				);
		
		return new LoginResponseDTO(
				token,
				user.getRole()
		);
	}
}
