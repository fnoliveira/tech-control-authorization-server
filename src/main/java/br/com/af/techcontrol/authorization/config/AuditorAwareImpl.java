package br.com.af.techcontrol.authorization.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;

public class AuditorAwareImpl implements AuditorAware<String> {

	@Value("${security.usuarionaologado}")
	String usuariosistema;

	@Override
	public String getCurrentAuditor() {

		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

		if (authentication == null || !authentication.isAuthenticated()) {
			return usuariosistema;
		}
		
		if(authentication.getPrincipal() instanceof String) {
			return (String)authentication.getPrincipal();
		}

		return ((User) authentication.getPrincipal()).getUsername();
	}
}
