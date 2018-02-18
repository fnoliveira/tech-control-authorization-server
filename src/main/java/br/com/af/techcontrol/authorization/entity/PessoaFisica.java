package br.com.af.techcontrol.authorization.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.br.CPF;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "PESSOA_FISICA")
@DiscriminatorValue(value = "PF")
@PrimaryKeyJoinColumn(name = "id")
public class PessoaFisica extends Pessoa {

	private static final long serialVersionUID = 1L;

	@NotBlank
	@CPF
	@Column(unique = true, length = 14)
	private String cpf;

	@Column
	private LocalDate dataNascimento;

	@Column(length = 1)
	private String sexo;

	private Boolean isEnable;
}
