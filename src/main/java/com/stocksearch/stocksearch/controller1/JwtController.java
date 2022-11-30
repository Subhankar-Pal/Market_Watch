package com.stocksearch.stocksearch.controller1;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.stocksearch.stocksearch.helper.JwtUtil;
import com.stocksearch.stocksearch.jwt.BadCredeltialsExceptions;
import com.stocksearch.stocksearch.model.JwtRequest;
import com.stocksearch.stocksearch.model.JwtResponse;
import com.stocksearch.stocksearch.services.CustomAdminDetailsService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class JwtController {
	@Autowired
	private AuthenticationManager authenticationmanager;

	@Autowired
	private CustomAdminDetailsService customAdminDetailsService;
	
	@Autowired
	private JwtUtil jwtUtil;
	
	@RequestMapping(value = "/token",method = RequestMethod.POST)
	public ResponseEntity<?> generateToken(@RequestBody JwtRequest jwtRequest) throws Exception{
		System.out.println(jwtRequest);
		try {
			this.authenticationmanager.authenticate(new UsernamePasswordAuthenticationToken(jwtRequest.getUsername(),jwtRequest.getPassword()));
		}
//		catch(UsernameNotFoundException e) {
//		
//			throw new Exception("Bad Credentials");
//		}
		catch(BadCredentialsException e) {
		
			throw new BadCredeltialsExceptions("Bad Credentials");
		}
		catch(Exception e) {
			throw new Exception(e);
		}
		
		//file area
		UserDetails userDetails = this.customAdminDetailsService.loadUserByUsername(jwtRequest.getUsername());
		
		String token = this.jwtUtil.generateToken(userDetails);
		//JSON "token: "value"
		
		return ResponseEntity.ok(new JwtResponse(token));
		
	}
	@RequestMapping(value = "/logout", method = RequestMethod.DELETE)
    public @ResponseBody ResponseEntity<?> logout(HttpSession session){

        String userName=(String)session.getAttribute("name");
        System.out.println("name: " + userName);
        session.invalidate();
        return ResponseEntity.ok("user logged out");

    } 
}
