package br.com.af.techcontrol.authorization.service;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.com.af.techcontrol.authorization.model.UserDetailsApp;
import br.com.af.techcontrol.authorization.repository.UserDetailsAppRepository;

@Service
public class UserDetailsAppService implements UserDetailsService {

	@Autowired
	private UserDetailsAppRepository userRepository;

	private void teste() {
		UserDetailsApp a = new UserDetailsApp();
		a.setUserName("demo@demo.com");
		a.setPassword("821f498d827d4edad2ed0960408a98edceb661d9f34287ceda2962417881231a");
		a.setRoles("STANDARD_USER, ADMIN_USER");
		userRepository.save(a);
	}
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		UserDetailsApp user = userRepository.findByUserName(username);

		if (user == null) {
			throw new UsernameNotFoundException(String.format("The username %s doesn't exist", username));
		}

		Collection<GrantedAuthority> authorities = new ArrayList<>();
		if (user.getRoles() != null) {
			String[] _roles = user.getRoles().split(",");
			for (String role : _roles) {
				authorities.add(new SimpleGrantedAuthority(role));
			}
		}
		if (authorities.size() == 0) {
			authorities.add(new SimpleGrantedAuthority("STANDARD_USER"));
		}
		UserDetails userDetails = new org.springframework.security.core.userdetails.User(user.getUserName(),
				user.getPassword(), authorities);

		return userDetails;

	}
}
