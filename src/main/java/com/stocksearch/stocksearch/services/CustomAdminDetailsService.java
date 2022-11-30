package com.stocksearch.stocksearch.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.stocksearch.stocksearch.dao.LoginDao;
import com.stocksearch.stocksearch.dao.StockDao;
import com.stocksearch.stocksearch.entities.Admin;


@Service
public class CustomAdminDetailsService implements UserDetailsService {

	@Autowired
	private LoginDao loginDao;
	
	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		
		
		
		Admin admin = loginDao.findByUsername(userName);
		if(admin == null) {
			throw new UsernameNotFoundException("Admin Not Found");
		}
		return new CustomUserDetails(admin);
		
//		if(userName.equals("Subhankar")) {
//			return new User("Subhankar","Pal" ,new ArrayList<>() );
//		}
//		else {
//			throw new UsernameNotFoundException("User not found !!");
//		}
	}

}
