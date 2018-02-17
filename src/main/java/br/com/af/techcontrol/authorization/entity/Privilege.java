package br.com.af.techcontrol.authorization.entity;

import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@RequiredArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Privilege extends BaseEntity {

	private static final long serialVersionUID = 1L;

	@NonNull
	private String name;

	@ManyToMany(cascade = CascadeType.ALL, mappedBy = "privileges")
	private Collection<Role> roles;


}
