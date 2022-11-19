package com.stocksearch.stocksearch.services;

import java.util.ArrayList;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
public class CustomAdminDetailsService implements UserDetailsService {

	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		if(userName.equals("Subhankar")) {
			return new User("Subhankar","Pal" ,new ArrayList<>() );
		}
		else {
			throw new UsernameNotFoundException("User not fould !!");
		}
	}

}
