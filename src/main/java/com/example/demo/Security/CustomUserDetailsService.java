package com.example.demo.security;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.demo.dao.UtilisateurDao;
import com.example.demo.entities.Role;
import com.example.demo.entities.Utilisateur;
@Service
public class CustomUserDetailsService implements UserDetailsService{
private UtilisateurDao userDao;
	@Autowired
	public CustomUserDetailsService(UtilisateurDao userDao) {
		this.userDao=userDao;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Utilisateur user=userDao.findByPrenom(username).orElseThrow(() -> new UsernameNotFoundException("Username not  found"));
	return new User(user.getPrenom(),user.getPassword(),mapRolesToAuthorities(user.getRoles()));
	}
	private Collection<GrantedAuthority>mapRolesToAuthorities(List<Role>roles)
	{
		return roles.stream().map(role -> new SimpleGrantedAuthority(role.getNom())).collect(Collectors.toList());	
	}

}
