package br.com.af.techcontrol.authorization.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.af.techcontrol.authorization.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

	User findByUsername(String username);

}
