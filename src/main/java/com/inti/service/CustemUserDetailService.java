package com.inti.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.inti.model.Role;
import com.inti.model.Utilisateurs;

@Service
public class CustemUserDetailService implements UserDetailsService {
	
	@Autowired
	IUtilisateurService utService;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
		
		Utilisateurs ut = utService.findByUsername(username);
		if(ut==null) {
			System.out.println("USer null");
			
			throw new UsernameNotFoundException(username);
		}
		List<GrantedAuthority> authorities = getGrantedAuthority(ut);
		System.out.println("l utilisateur --> " +ut);
		
		
		return new User(ut.getUsername(), ut.getPassword(), authorities);
		
	}
	
	
	private List<GrantedAuthority> getGrantedAuthority(Utilisateurs u){
		
		List<GrantedAuthority> lGrAuth = new ArrayList<>();
		
//		List<Role> lR = u.getRole()[0];
		
//		for(Role r: lR) {
			lGrAuth.add(new SimpleGrantedAuthority(u.getRole().getNom()));
			
//		}
		return lGrAuth;
		
	}

}
