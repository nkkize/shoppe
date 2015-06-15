/**
 * 
 */
package com.shoppe.security.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 * @author NarenderK
 *
 */
@Configuration
@ComponentScan(basePackages={"com.shoppe"})
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Autowired
	@Qualifier("userDetailsService")
	UserDetailsService userDetailsService;
	//equivalent of this in spring-security.xml file is
		/*<authentication-manager>
			  <authentication-provider>
			    <user-service>
					<user name="naren" password="123456" authorities="ROLE_USER" />
					<user name="admin" password="123456" authorities="ROLE_ADMIN" />
			    </user-service>
			  </authentication-provider>
		  </authentication-manager>*/
	
	/*@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
	  auth.inMemoryAuthentication().withUser("naren").password("123456").roles("USER");
	  auth.inMemoryAuthentication().withUser("admin").password("123456").roles("ADMIN");
	}*/
	
	//equivalent of this in spring-security.xml file is
	/*<http auto-config="true">
		<intercept-url pattern="/admin**" access="ROLE_ADMIN" />
	  </http>*/
	
	/*@Override
	protected void configure(HttpSecurity http) throws Exception {
 
	  http.authorizeRequests()
		.antMatchers("/shoppe").access("hasRole('ADMIN')")
		.and().formLogin();
	}*/
	
	
	/*<http auto-config="true">
	  <intercept-url pattern="/admin**" access="ROLE_USER" />
	  <form-login 
		login-page="/login" 
	    default-target-url="/welcome" 
		authentication-failure-url="/login?error" 
		username-parameter="username"
		password-parameter="password" />
	  <logout logout-success-url="/login?logout" />
	  <!-- enable csrf protection -->
	  <csrf/>
	  </http>*/

	
	// .csrf() is optional, enabled by default, if using WebSecurityConfigurerAdapter constructor
		@Override
	protected void configure(HttpSecurity http) throws Exception {
			http.authorizeRequests()
            .anyRequest().authenticated()
            .and().formLogin()
			.loginPage("/login").permitAll()
			.defaultSuccessUrl("/admin")
			.failureUrl("/login?error")
			.usernameParameter("userName")
			.passwordParameter("password")
			.and().logout().logoutSuccessUrl("/login?logout")
			.and().csrf()
			.and().exceptionHandling().accessDeniedPage("/403");
            
		}
		
		
		
	 
		@Autowired
		public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
			auth.userDetailsService(userDetailsService);
		}

}
