package com.mosine.librarymanagement.entities;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;


@Entity
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Email
	@NotBlank(message = "Login must not be blank")
	@Column(unique = true)
	private String login;

	@NotBlank(message = "Password must not be blank")
	//@Size(min = 8, max = 16, message = "Password must be at least {min} characters")
	private String password;

	@Enumerated(EnumType.STRING)
	private Role role = Role.ADMIN;

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		try {
			MessageDigest digest = MessageDigest.getInstance("SHA-256");
			byte[] encodedHash = digest.digest(password.getBytes(StandardCharsets.UTF_8));
			this.password = new String(encodedHash, StandardCharsets.UTF_8);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
	}
}
