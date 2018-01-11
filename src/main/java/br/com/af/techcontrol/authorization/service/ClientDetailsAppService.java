package br.com.af.techcontrol.authorization.service;

import java.util.Arrays;
import java.util.HashSet;

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
		c.setAuthorizedGrantTypes(new HashSet<>(Arrays.asList("password")));
		c.setScope(new HashSet<>(Arrays.asList("read,write")));
		c.setResourceIds(new HashSet<>(Arrays.asList("rest-server")));
		clientDetailsAppRepository.save(c);
	}
	
	
	@Override
	public ClientDetails loadClientByClientId(String clientId) throws ClientRegistrationException {
		
		ClientDetailsApp clientDetailsApp = clientDetailsAppRepository.findByClientId(clientId);

		BaseClientDetails baseClientDetails = new BaseClientDetails();

		baseClientDetails.setClientId(clientDetailsApp.getClientId());
		baseClientDetails.setClientSecret(clientDetailsApp.getClientSecret());
		baseClientDetails.setAuthorizedGrantTypes(clientDetailsApp.getAuthorizedGrantTypes());
		baseClientDetails.setScope(clientDetailsApp.getScope());
		baseClientDetails.setResourceIds(clientDetailsApp.getResourceIds());

		return baseClientDetails;
	}


}