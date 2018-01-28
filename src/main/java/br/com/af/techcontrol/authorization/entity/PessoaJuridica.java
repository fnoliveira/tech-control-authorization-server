package br.com.af.techcontrol.authorization.entity;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
@Entity
@Table(name = "PESSOA_JURIDICA")
@DiscriminatorValue(value = "PJ")
@PrimaryKeyJoinColumn(name = "id")
public class PessoaJuridica extends Pessoa {
 
	@Column(name = "razao_social", length = 100, nullable = false)
	private String razaoSocial;
	
	@Column(name = "cnpj", length = 14, nullable = false)
	private String cnpj;
	
	@Column(name = "inscricao_estadual", length = 15)
	private String inscricaoEstadual;
	
	@Column(name = "inscricao_municipal", length = 15)
	private String inscricaoMunicipal;

}

