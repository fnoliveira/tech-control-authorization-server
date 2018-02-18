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

@AllArgsConstructor
@RequiredArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Email extends BaseEntity {

	private static final long serialVersionUID = 1L;

	@NonNull
	private String tipo;

	@NonNull
	private String endereco;

	@NonNull
	private Boolean isPrincipal;

	@NonNull
	private Boolean isEnable;
	
	@ManyToOne
	@JoinColumn(name = "contato_id")
	private Contato contato;

}
