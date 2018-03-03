package br.com.af.techcontrol.authorization.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.validator.constraints.Email;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@RequiredArgsConstructor
@NoArgsConstructor
public class Contato extends BaseEntityAudit {

	private static final long serialVersionUID = 1L;

	@NonNull
	@Getter
	@Setter
	private String tipo;

	@Getter
	@Setter
	@Fetch(FetchMode.SELECT)
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name = "contato_id", referencedColumnName = "id")
	private List<Telefone> telefones;

	@Getter
	@Setter
	@Email(message = "E-mail inválido")
	@Column(unique = true)
	private String email;
}
