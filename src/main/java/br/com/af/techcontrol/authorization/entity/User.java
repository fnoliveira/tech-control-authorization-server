package br.com.af.techcontrol.authorization.entity;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@RequiredArgsConstructor
@NoArgsConstructor
public class User extends BaseEntityAudit {

	private static final long serialVersionUID = 1L;

	@NonNull
	@Getter
	@Setter
	@OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "pessoa_id")
    private Pessoa pessoa;
	
	@NonNull
	@Getter
	@Setter
	@Column(unique=true)
	private String username;
    
	@NonNull
	@Getter
	@Setter
    private String password;
    
	@Getter
	@Setter
    @Fetch(FetchMode.SELECT)
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable( 
        name = "users_roles", 
        joinColumns = @JoinColumn(
          name = "user_id", referencedColumnName = "id"), 
        inverseJoinColumns = @JoinColumn(
          name = "role_id", referencedColumnName = "id")) 
    private Collection<Role> roles = new ArrayList<Role>();

	@NonNull
	@Getter
	@Setter
	private Boolean isEnable;

}
