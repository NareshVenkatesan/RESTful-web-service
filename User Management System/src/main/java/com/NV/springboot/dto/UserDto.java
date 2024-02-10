package com.NV.springboot.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Schema(
		description = "UserDTO Model Information "
	   )
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserDto {
	
	private long id;
	
	@Schema(
			description = "User First Name"
		   )
	@NotBlank(message = "User FirstName should not be null or empty")
	private String firstName;
	
	@Schema(
			description = "User Last Name"
		   )
	@NotBlank(message = "User LastName should not be null or empty")
	private String lastName;
	
	@Schema(
			description = "User Email Adress"
		   )
	@NotBlank(message = "user Email should not be null or empty")
	@Email(message = "User Email should be Valid")
	private String email;

}
