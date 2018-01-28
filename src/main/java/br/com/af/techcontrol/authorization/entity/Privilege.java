package br.com.af.techcontrol.authorization.entity;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@EqualsAndHashCode(callSuper = false)
@Data
public class Privilege extends BaseEntity{

	private String name;

	@ManyToMany(mappedBy = "privileges")
	private Collection<Role> roles;

	public Privilege(String name) {
		super();
		this.name = name;
	}
	
	public Privilege() {
	}
	
}
