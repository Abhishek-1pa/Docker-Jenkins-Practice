package com.cg.flatrental.app.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity

@JsonIgnoreProperties(value = {"userId"}, allowGetters = true)
@Table(name = "USERS")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long userId;
	
	//@NotBlank(message = "User Name must not be empty or null")
	private String userName;
	
	@NotBlank(message = "Password must not be empty or null")
	private String password;
	
	@NotBlank(message = "User Type must not be empty or null")
	private String userType;
	
	
	
}
