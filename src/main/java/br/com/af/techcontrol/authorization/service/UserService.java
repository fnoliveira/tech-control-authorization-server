package br.com.af.techcontrol.authorization.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.com.af.techcontrol.authorization.entity.Role;
import br.com.af.techcontrol.authorization.entity.User;
import br.com.af.techcontrol.authorization.repository.UserRepository;

@Service
@Transactional
public class UserService implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		try {
			User user = userRepository.findByUsername(username);
			if (user == null) {
				throw new UsernameNotFoundException("No user found with username: " + username);
			}
			org.springframework.security.core.userdetails.User userDetails = new org.springframework.security.core.userdetails.User(
					user.getUsername(), user.getPassword(), user.isEnabled(), true, true, true,
					getAuthorities(user.getRoles()));
			return userDetails;
		} catch (final Exception e) {
			throw new RuntimeException(e);
		}
	}

	private final Collection<? extends GrantedAuthority> getAuthorities(Collection<Role> roles) {
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		for (Role role : roles) {
			authorities.add(new SimpleGrantedAuthority(role.getName()));
			authorities.addAll(role.getPrivileges().stream().map(p -> new SimpleGrantedAuthority(p.getName()))
					.collect(Collectors.toList()));
		}
		return authorities;
	}
}