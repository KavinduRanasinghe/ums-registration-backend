package lk.ac.wusl.fas.ums_registration_backend.application.dto.student;

import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.*;
import jakarta.validation.constraints.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import lk.ac.wusl.fas.ums_registration_backend.domain.enums.Combination;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class StudentRegistrationDTO {
	
	@NotBlank
	private String regNo;
	
	@NotBlank
	private String name;
	
	private String initials;
	
	@NotBlank
	private String gender;
	
	@NotBlank
	private String district;
	
	@JsonProperty("zScore")
	@JsonAlias({"zscore", "z_score"})
	@NotNull
	private Double zScore;
	
	@NotNull
	private Integer level;
	
	private Combination preference1;
	
	private Combination preference2;
	
	private Combination preference3;
}
