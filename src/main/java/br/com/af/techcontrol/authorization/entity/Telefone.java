package br.com.af.techcontrol.authorization.entity;

import javax.persistence.Entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;

@Entity
@AllArgsConstructor
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

	@NonNull
	private Boolean isEnable;
}
