package org.webwork.find.service.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import org.webwork.find.domain.UserRole;
import org.webwork.find.repositor.UserHibernate;


@Service("userDetailService")
public class UserDetailsServiceImpl implements UserDetailsService{
	
	@Autowired
	UserHibernate userHibernate;
	
	@Transactional(readOnly = true)
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		
		org.webwork.find.domain.User user = userHibernate.findUserByName(userName); //get user object from database
		List<GrantedAuthority> authorities = buildUserAuthority(user.getUserRole());
		
		return (UserDetails) buildUserForAuthentication(user, authorities);
	}
	
	private User buildUserForAuthentication(org.webwork.find.domain.User user, List<GrantedAuthority> authorities){
		User u = new User(user.getFirstName(), user.getPassword(), authorities);
		return u;
	}
	
	private List<GrantedAuthority> buildUserAuthority(Set<UserRole> userRoles){
		Set<GrantedAuthority> setAuth = new HashSet<GrantedAuthority>();
		
		for(UserRole userRole: userRoles){
			setAuth.add(new SimpleGrantedAuthority(userRole.getRole()));
		}
		
		List<GrantedAuthority> result = new ArrayList<GrantedAuthority>(setAuth);
		return result;
	}

}
