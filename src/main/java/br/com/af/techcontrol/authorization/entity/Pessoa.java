package br.com.af.techcontrol.authorization.entity;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name = "PESSOA")
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "TIPO_DE_PESSOA")
@Data
@EqualsAndHashCode(callSuper = false)
public abstract class Pessoa extends BaseEntityAudit {

	@Column(name = "nome", length = 50, nullable = false)
	private String nome;
	
	@Column(name = "observacao", length = 255, nullable = true)
	private String observacao;
    
}
