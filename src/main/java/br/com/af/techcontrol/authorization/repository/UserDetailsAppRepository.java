package br.com.af.techcontrol.authorization.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.af.techcontrol.authorization.model.UserDetailsApp;

public interface UserDetailsAppRepository extends MongoRepository<UserDetailsApp, String> {
	public UserDetailsApp findByUserName(String userName);
}
