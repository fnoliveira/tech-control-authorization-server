package br.com.af.techcontrol.authorization.entity;

import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Endereco extends BaseEntity {

	private static final long serialVersionUID = 1L;

	private String cep;

	private String logradouro;

	private String numero;

	private String complemento;

	private String bairro;

	private String cidade;

	private String uf;

	private String pais;

	@ManyToMany(cascade = CascadeType.ALL, mappedBy = "enderecos")
	private Collection<Pessoa> pessoas;
	
	private Boolean isEnable;
}
