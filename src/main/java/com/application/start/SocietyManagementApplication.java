package com.application.start;

import com.application.start.dao.UserDAO;
import com.application.start.entity.CustomUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

@SpringBootApplication(exclude = HibernateJpaAutoConfiguration.class)
public class SocietyManagementApplication {
	public static void main(String[] args) {
		SpringApplication.run(SocietyManagementApplication.class, args);
	}
	@Autowired
	public void authenticationManger(AuthenticationManagerBuilder builder, UserDAO repo) throws Exception {
		builder.userDetailsService(new UserDetailsService() {
			@Override
			public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
				return new CustomUserDetails(repo.findByUserName(s));
			}
		});
	}
}