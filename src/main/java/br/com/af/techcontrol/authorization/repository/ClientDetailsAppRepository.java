package br.com.af.techcontrol.authorization.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.af.techcontrol.authorization.model.ClientDetailsApp;

public interface ClientDetailsAppRepository extends MongoRepository<ClientDetailsApp, String> {
	public ClientDetailsApp findByClientId(String clientId);
}
