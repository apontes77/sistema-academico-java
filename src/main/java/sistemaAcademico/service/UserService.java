package sistemaAcademico.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import sistemaAcademico.model.User;
import sistemaAcademico.web.dto.UserRegistrationDto;

public interface UserService extends UserDetailsService{
	User save(UserRegistrationDto registrationDto);
}
