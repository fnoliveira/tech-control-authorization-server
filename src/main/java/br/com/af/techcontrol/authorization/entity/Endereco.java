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
public class Endereco extends BaseEntityAudit {

	private static final long serialVersionUID = 1L;

	@NonNull
	@Getter
	@Setter
	private String cep;

	@NonNull
	@Getter
	@Setter
	private String logradouro;

	@NonNull
	@Getter
	@Setter
	private String numero;

	@NonNull
	@Getter
	@Setter
	private String complemento;

	@NonNull
	@Getter
	@Setter
	private String bairro;

	@NonNull
	@Getter
	@Setter
	private String cidade;

	@NonNull
	@Getter
	@Setter
	private String uf;

	@NonNull
	@Getter
	@Setter
	private String pais;

	@NonNull
	@Getter
	@Setter
	private Boolean isEnable;

}
