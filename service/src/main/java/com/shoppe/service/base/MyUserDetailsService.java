/**
 * 
 */
package com.shoppe.service.base;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.shoppe.persistence.entity.User;
import com.shoppe.persistence.entity.UserRole;

/**
 * @author NarenderK
 *
 */
@Service("userDetailsService")
public class MyUserDetailsService implements UserDetailsService {

	@Autowired
	private UserService userService;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userService.findUser(username);
		List<GrantedAuthority> authorities = buildUserAuthorities(user.getUserRole());
		return buildUserForAuthentication(user, authorities);
	}

	private UserDetails buildUserForAuthentication(User user, List<GrantedAuthority> authorities) {
		return new org.springframework.security.core.userdetails.User(
				user.getUsername(), user.getPassword(), user.isEnabled(), true,
				true, true, authorities);
	}

	private List<GrantedAuthority> buildUserAuthorities(UserRole userRole) {
		Set<GrantedAuthority> authSet = new HashSet<GrantedAuthority>();

		authSet.add(new SimpleGrantedAuthority(userRole.getRole()));

		List<GrantedAuthority> authList = new ArrayList<GrantedAuthority>(
				authSet);
		return authList;
	}

}
