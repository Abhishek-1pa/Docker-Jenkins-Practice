package com.cg.flatrental.app.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="Flat_Address_Table")
public class FlatAddress {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer houseNo;
	
	//@NotBlank(message = "Street must not be empty or null")
	private String street;
	
	//@NotBlank(message = "City must not be empty or null")
	private String city;
	
	//@NotBlank(message = "State must not be empty or null")
	private String state;
	
	//@NotBlank(message = "PinCode must not be empty or null")
	private Integer pin;
	
	//@NotBlank(message = "Country must not be empty or null")
	private String country;
}
