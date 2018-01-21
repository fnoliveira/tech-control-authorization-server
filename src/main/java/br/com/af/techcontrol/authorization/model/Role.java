package br.com.af.techcontrol.authorization.model;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Role {

	@Id
	private int id;
	
	private String role;
}
