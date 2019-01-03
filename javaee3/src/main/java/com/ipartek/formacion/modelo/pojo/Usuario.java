package com.ipartek.formacion.modelo.pojo;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;




public class Usuario {
	
	private Long id;
		
	@NotEmpty
	@Pattern(regexp = "^[A-Za-z0-9](([_\\.\\-]?[a-zA-Z0-9]+)*)@([A-Za-z0-9]+)(([\\.\\-]?[a-zA-Z0-9]+)*)\\.([A-Za-z]{2,})$")
	private String email;
	
	@NotEmpty
	@Size(min=5, max=50)
	private String password;

	public Usuario() {
		super();
		this.id = (long) -1;
		this.email = "";
		this.password = "";
	}

	public Usuario(Long id, String email, String password) {
		this();
		setId(id);
		setEmail(email);
		setPassword(password);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", email=" + email + ", password=" + password + "]";
	}
}
