package br.com.af.techcontrol.authorization.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.af.techcontrol.authorization.model.UserDetailsApp;

public interface UserDetailsAppRepository extends JpaRepository<UserDetailsApp, String> {
}
