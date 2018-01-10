package br.com.af.techcontrol.authorization.model;

import java.util.List;
import java.util.Set;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.security.core.GrantedAuthority;

import lombok.Data;

@Document(collection="client_app")
@Data
public class ClientDetailsApp {

	@Id
	private String clientId;

	private String clientSecret;

	private Set<String> scope;

	private Set<String> resourceIds;

	private Set<String> authorizedGrantTypes;
	
	private Set<String> registeredRedirectUris;
	
	private Set<String> autoApproveScopes;

	private List<GrantedAuthority> authorities;
	
	private Integer accessTokenValiditySeconds;
	
	private Integer refreshTokenValiditySeconds;

	
}