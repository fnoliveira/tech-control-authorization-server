package br.com.af.techcontrol.authorization.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Document(collection="ClientApp")
@Data
public class ClientDetailsApp {

	@Id
	private String clientId;

	private String clientSecret;

	private String scopes;

	private String grantTypes;

	private String resourceIds;

	
}