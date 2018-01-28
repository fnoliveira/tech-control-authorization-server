package br.com.af.techcontrol.authorization.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.af.techcontrol.authorization.entity.Privilege;

public interface PrivilegeRepository extends JpaRepository<Privilege, Long> {

	Privilege findByName(String name);

}
