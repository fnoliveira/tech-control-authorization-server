package br.com.af.techcontrol.authorization.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Document(collection="UserApp")
@Data
public class UserDetailsApp {

	@Id
	private String userName;

	private String password;

	private String roles;

}
