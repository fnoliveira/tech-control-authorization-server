package br.com.af.techcontrol.authorization.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.af.techcontrol.authorization.entity.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {

	Role findByName(String name);

}
