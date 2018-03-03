package br.com.af.techcontrol.authorization.entity;

import javax.persistence.Entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@RequiredArgsConstructor
@NoArgsConstructor
public class Telefone extends BaseEntityAudit {

	private static final long serialVersionUID = 1L;

	@NonNull
	@Getter
	@Setter
	private String tipo;

	@NonNull
	@Getter
	@Setter
	private String ddd;

	@NonNull
	@Getter
	@Setter
	private String numero;

	@NonNull
	@Getter
	@Setter
	private Boolean isEnable;
}
