package br.com.af.techcontrol.authorization.entity;

import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@DiscriminatorColumn(name = "TIPO_DE_PESSOA")
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "PESSOA")
public abstract class Pessoa extends BaseEntityAudit {

	private static final long serialVersionUID = 1L;

	@NotBlank
	@Size(min = 3, max = 50)
	@Column(length = 50)
	private String nome;
	
	@NonNull
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "pessoas_enderecos", 
		joinColumns = @JoinColumn(name = "pessoa_id", referencedColumnName = "id"),
		inverseJoinColumns = @JoinColumn(name = "endereco_id",
		referencedColumnName = "id"))
	private Collection<Endereco> enderecos;

	@Size(min = 3, max = 255)
	@Column(length = 255)
	private String observacao;

	@OneToOne(mappedBy="pessoa")
	private Contato contato;
	

}
