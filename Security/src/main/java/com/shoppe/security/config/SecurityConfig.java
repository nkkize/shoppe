/**
 * 
 */
package com.shoppe.security.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * @author NarenderK
 *
 */
@Configuration
@ComponentScan(basePackages={"com.shoppe"})
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	
	//equivalent of this in spring-security.xml file is
		/*<authentication-manager>
			  <authentication-provider>
			    <user-service>
					<user name="naren" password="123456" authorities="ROLE_USER" />
					<user name="admin" password="123456" authorities="ROLE_ADMIN" />
			    </user-service>
			  </authentication-provider>
		  </authentication-manager>*/
	
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
	  auth.inMemoryAuthentication().withUser("naren").password("123456").roles("USER");
	  //auth.inMemoryAuthentication().withUser("admin").password("123456").roles("ADMIN");
	}
	
	//equivalent of this in spring-security.xml file is
	/*<http auto-config="true">
		<intercept-url pattern="/admin**" access="ROLE_ADMIN" />
	  </http>*/
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
 
	  http.authorizeRequests()
		.antMatchers("/login").access("hasRole('USER')")
		.and().formLogin().loginPage("/login").permitAll();
	}

}
