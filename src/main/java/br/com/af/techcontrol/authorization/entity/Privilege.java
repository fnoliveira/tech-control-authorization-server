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
public class Privilege extends BaseEntity {

	private static final long serialVersionUID = 1L;

	@NonNull
	private String name;

}
