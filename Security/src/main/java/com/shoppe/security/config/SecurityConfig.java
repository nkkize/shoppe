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
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

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

	/*@Override
	public void configure(WebSecurity web) throws Exception {
		web
        .ignoring()
            .antMatchers("/js/**","/css/**","/img/**","/webjars/**","/views/**");
	}*/
	
	// .csrf() is optional, enabled by default, if using WebSecurityConfigurerAdapter constructor
		@Override
	protected void configure(HttpSecurity http) throws Exception {
			http
            // access-denied-page: this is the page users will be
            // redirected to when they try to access protected areas.
			.formLogin()
				.loginPage("/login")
				.defaultSuccessUrl("/home")
				.failureUrl("/login?error")
				.usernameParameter("username")
				.passwordParameter("password").permitAll()
				.and()
			.authorizeRequests()
				.antMatchers("/newUser", "/signup").permitAll()
				.anyRequest().authenticated()
				.and()
				.csrf().disable();            
		}
	 
		@Autowired
		public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
			auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
		}

		/*.and()
		.logout()
		.logoutSuccessUrl("/login?logout")
		
		
				.anyRequest().authenticated()*/

		@Autowired
		private PasswordEncoder passwordEncoder() {
			return new BCryptPasswordEncoder();
		}

}
