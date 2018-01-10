package br.com.af.techcontrol.authorization.model;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Document(collection="user_app")
@Data
public class UserDetailsApp {

	@Id
	private String userName;

	private String password;

	private List<String> roles;

}
