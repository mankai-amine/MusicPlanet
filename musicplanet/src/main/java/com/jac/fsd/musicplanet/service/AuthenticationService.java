package com.jac.fsd.musicplanet.service;

import com.jac.fsd.musicplanet.DTO.LoginUserDto;
import com.jac.fsd.musicplanet.DTO.RegisterUserDto;
import com.jac.fsd.musicplanet.entity.User;
import com.jac.fsd.musicplanet.exception.AuthException;
import com.jac.fsd.musicplanet.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;

    @Autowired
    public AuthenticationService(UserRepository userRepository, PasswordEncoder passwordEncoder, AuthenticationManager authenticationManager) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.authenticationManager = authenticationManager;
    }

    public User signup(RegisterUserDto registerUserDto) {
        User user = new User();
        user.setUsername(registerUserDto.getUsername());
        user.setPassword(passwordEncoder.encode(registerUserDto.getPassword()));
        return userRepository.save(user);
    }

    public User authenticate(LoginUserDto loginUserDto) {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(loginUserDto.getUsername(), loginUserDto.getPassword())
            );
        }catch (BadCredentialsException e){
            throw new AuthException(HttpStatus.UNAUTHORIZED, "Invalid username or password");
        }
        return userRepository.findByUsername(loginUserDto.getUsername())
                .orElseThrow(() -> new AuthException(HttpStatus.UNAUTHORIZED, "User not found: " + loginUserDto.getUsername()));
    }

}
