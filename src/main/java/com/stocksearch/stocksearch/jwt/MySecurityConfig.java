package com.stocksearch.stocksearch.jwt;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.filters.CorsFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.util.UrlPathHelper;

import com.stocksearch.stocksearch.services.CustomAdminDetailsService;

@SuppressWarnings("deprecation")
@Configuration
@EnableWebSecurity
public class MySecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Autowired
	private CustomAdminDetailsService customAdminDetailsService;
	@Autowired
	private JwtAuthenticationFilter jwtFilter;
	
	@Autowired
	private JwtAuthenticationEntryPoint entryPoint;
	
	@Autowired
	private UserDetailsService userDetailsService;
	
	
	@Override
	protected void configure(HttpSecurity http) throws Exception{
		http
			.csrf()
			.disable()
			.cors()
			.disable()
			.authorizeRequests()
			.antMatchers("/token").permitAll()
//			.antMatchers("/token")
//			.hasAuthority("ADMIN")
			.anyRequest().authenticated()
			.and()
			.httpBasic()
			.and()
			.logout()
				.logoutSuccessHandler(new LogoutSuccessHandler() {

					@Override
					public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response,
							Authentication authentication) throws IOException, ServletException {
						// TODO Auto-generated method stub
						System.out.println("the admin "+authentication.getName()+" has logged out.");
						UrlPathHelper helper = new UrlPathHelper();
						String context = helper.getContextPath(request);
						response.sendRedirect(context+"/logout_success");
					}
					
				})
				.permitAll()
			.and()
			.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
			.and()
			.exceptionHandling().authenticationEntryPoint(entryPoint);
		http.addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);
	}
	
//	
	@Override
	public void configure(WebSecurity web) throws Exception {
	    web.ignoring().antMatchers("/getAllStocks/{symbol}").antMatchers("/getAllStocks");
	}
	
//	@Override
//	protected void configure(AuthenticationManagerBuilder auth) throws Exception{
//		auth.userDetailsService(customAdminDetailsService);
//		
//	}
//	
//	@Bean
//	public PasswordEncoder passWordEncoder() {
//		return NoOpPasswordEncoder.getInstance();
//		
//	}
	
	@Bean
	public AuthenticationManager authenticationManagerBean() throws Exception{
		return super.authenticationManagerBean();
	}
	
	@Bean
	AuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
		provider.setUserDetailsService(userDetailsService);
		provider.setPasswordEncoder(new BCryptPasswordEncoder());
		return provider;
	}
	

	
}
