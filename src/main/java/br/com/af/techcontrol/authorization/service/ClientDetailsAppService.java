package br.com.af.techcontrol.authorization.service;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.ClientRegistrationException;
import org.springframework.security.oauth2.provider.client.BaseClientDetails;
import org.springframework.stereotype.Service;

import br.com.af.techcontrol.authorization.model.ClientDetailsApp;
import br.com.af.techcontrol.authorization.repository.ClientDetailsAppRepository;

@Service
public class ClientDetailsAppService implements ClientDetailsService {

	@Autowired
	ClientDetailsAppRepository clientDetailsAppRepository;

	
	public void teste() {
		ClientDetailsApp c = new ClientDetailsApp();
		
		c.setClientId("web_app");
		c.setClientSecret("123456");
		c.setGrantTypes("password");
		c.setScopes("read,write");
		c.setResourceIds("testjwtresourceid");
		clientDetailsAppRepository.save(c);
	}
	
	
	@Override
	public ClientDetails loadClientByClientId(String clientId) throws ClientRegistrationException {

		ClientDetailsApp clientDetailsApp = clientDetailsAppRepository.findByClientId(clientId);

		BaseClientDetails baseClientDetails = new BaseClientDetails();

		baseClientDetails.setClientId(clientDetailsApp.getClientId());
		baseClientDetails.setClientSecret(clientDetailsApp.getClientSecret());
		baseClientDetails.setAuthorizedGrantTypes(getGrantTypes(clientDetailsApp.getGrantTypes()));
		baseClientDetails.setScope(getScopes(clientDetailsApp.getScopes()));
		baseClientDetails.setResourceIds(getResourceIds(clientDetailsApp.getResourceIds()));

		return baseClientDetails;
	}

	public Collection<String> getScopes(String scopes) {
		if (scopes != null) {
			return Arrays.asList(scopes.split(","));
		}
		return null;
	}
	
	public List<String> getResourceIds(String resourceIds) {
		if (resourceIds != null) {
			return Arrays.asList(resourceIds.split(","));
		}
		return null;
	}

	public Collection<String> getGrantTypes(String grantTypes) {
		if (grantTypes != null) {
			return Arrays.asList(grantTypes.split(","));
		}
		return null;
	}

}