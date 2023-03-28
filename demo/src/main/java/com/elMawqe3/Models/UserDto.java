package com.elMawqe3.Models;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.elMawqe3.Configurations.PasswordMatches;
import com.elMawqe3.Configurations.ValidEmail;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

@Getter
@Setter
public class UserDto {
	@NotNull
	@NotEmpty
    private String username;
   
	@NotNull
	@NotEmpty
	@PasswordMatches
    private String password;
    private String matchingPassword;
    
    @NotNull
	@NotEmpty
	@ValidEmail
    private String email;
}
