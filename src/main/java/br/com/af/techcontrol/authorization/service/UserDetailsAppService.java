package br.com.af.techcontrol.authorization.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import br.com.af.techcontrol.authorization.model.UserDetailsApp;
import br.com.af.techcontrol.authorization.repository.UserDetailsAppRepository;

@Service
public class UserDetailsAppService implements UserDetailsService {

	@Autowired
	private UserDetailsAppRepository userRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;

	private void teste() {
		UserDetailsApp a = new UserDetailsApp();
		a.setUserName("demo@demo.com");
		a.setPassword(passwordEncoder.encode("demo"));
		a.setRoles(Arrays.asList("ROLE_STANDARD"));
		userRepository.save(a);
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		UserDetailsApp user = userRepository.findByUserName(username);

		Collection<GrantedAuthority> roles = new ArrayList<>();

		if (user == null) {
			throw new UsernameNotFoundException(String.format("The username %s doesn't exist", username));
		}

		user.getRoles().forEach(role -> {
			roles.add(new SimpleGrantedAuthority(role));
		});

		return new User(user.getUserName(), user.getPassword(), roles);

	}
}
