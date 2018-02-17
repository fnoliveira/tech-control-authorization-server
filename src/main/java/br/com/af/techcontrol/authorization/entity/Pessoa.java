package br.com.af.techcontrol.authorization.entity;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
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

	@Size(min = 3, max = 255)
	@Column(length = 255)
	private String observacao;

}
