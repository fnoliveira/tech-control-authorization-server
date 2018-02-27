package br.com.af.techcontrol.authorization.entity;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

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
public class Role extends BaseEntity {

	private static final long serialVersionUID = 1L;
	
	@NonNull
	private String name;

	@Fetch(FetchMode.SELECT)
	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinTable(
			name = "roles_privileges", joinColumns = @JoinColumn(
					name = "role_id", referencedColumnName = "id"), 
			inverseJoinColumns = @JoinColumn(
					name = "privilege_id", referencedColumnName = "id"))
	private Collection<Privilege> privileges = new ArrayList<Privilege>();

	
}
