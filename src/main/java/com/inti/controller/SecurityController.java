package com.inti.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.inti.config.AuthentificationRequest;
import com.inti.config.AuthentificationResponse;
import com.inti.config.jwtUtil;

@RestController
@RequestMapping("/api")
@CrossOrigin("http://localhost:4200")
public class SecurityController {

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private UserDetailsService custemUserDetailsService;

	@Autowired
	private jwtUtil jwtokenUtil;

	@RequestMapping(value = "/loginUserJwt", method = RequestMethod.POST)
	public ResponseEntity<?> authenticate(@RequestBody AuthentificationRequest authentificationRequest)
			throws Exception {
		try {
			System.out.println("je rentre dans le try");
			System.out.println(authentificationRequest.getUsername() + " password --> "+ authentificationRequest.getPassword());
			
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
					authentificationRequest.getUsername(), authentificationRequest.getPassword()));

		} catch (BadCredentialsException e) {
			// TODO: handle exception
			throw new Exception("incorrect username ou password", e);
		}
		System.out.println("je suis juste après le try");
		final UserDetails userdetails = custemUserDetailsService
				.loadUserByUsername(authentificationRequest.getUsername());

		System.out.println("je suis apres user details");

		final String jwt = jwtokenUtil.generateToken(userdetails);
		System.out.println("token --> " + jwt);

		return new ResponseEntity(new AuthentificationResponse(jwt), HttpStatus.OK);
	}

}
