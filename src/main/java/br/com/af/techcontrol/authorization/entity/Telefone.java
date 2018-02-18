package br.com.af.techcontrol.authorization.entity;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@RequiredArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Telefone extends BaseEntity {

	private static final long serialVersionUID = 1L;

	@NonNull
	private String tipo;

	@NonNull
	private String ddd;

	@NonNull
	private String numero;

	@ManyToOne
	@JoinColumn(name = "contato_id")
	private Contato contato;

	@NonNull
	private Boolean isEnable;
}
