package br.com.af.techcontrol.authorization.entity;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.br.CNPJ;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "PESSOA_JURIDICA")
@DiscriminatorValue(value = "PJ")
@PrimaryKeyJoinColumn(name = "id")
public class PessoaJuridica extends Pessoa {

	private static final long serialVersionUID = 1L;

	@NotBlank
	@Size(min = 3, max = 100)
	@Column(length = 100)
	private String razaoSocial;

	@NotBlank
	@CNPJ
	@Column
	private String cnpj;

	@Column(length = 15)
	private String inscricaoEstadual;

	@Column(length = 15)
	private String inscricaoMunicipal;

	private Boolean isEnable;
}
