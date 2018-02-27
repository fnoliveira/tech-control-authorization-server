package br.com.af.techcontrol.authorization.entity;

import javax.persistence.Entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Endereco extends BaseEntity {

	private static final long serialVersionUID = 1L;

	@NonNull
	private String cep;

	@NonNull
	private String logradouro;

	@NonNull
	private String numero;

	@NonNull
	private String complemento;

	@NonNull
	private String bairro;

	@NonNull
	private String cidade;

	@NonNull
	private String uf;

	@NonNull
	private String pais;

	@NonNull
	private Boolean isEnable;
}
