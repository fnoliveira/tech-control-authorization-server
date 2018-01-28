package br.com.af.techcontrol.authorization.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
@Entity
@Table(name = "PESSOA_FISICA")
@DiscriminatorValue(value = "PF")
@PrimaryKeyJoinColumn(name = "id")
public class PessoaFisica extends Pessoa {

	@Column(unique = true, name = "cpf", length = 14, nullable = false)
	private String cpf;

	@Temporal(TemporalType.DATE)
	@Column(name = "data_nascimento")
	private Date dataNascimento;

	@Column(name = "sexo", length = 1)
	private String sexo;


}
