package com.cg.flatrental.app.entity;


import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="FLAT")
@JsonIgnoreProperties(value = {"flatId"}, allowGetters = true)
public class Flat {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long flatId;
	
	@NotBlank(message = "Cost must not be empty or null")
	private Double cost;
	
	
	@OneToOne(cascade = CascadeType.DETACH,fetch=FetchType.LAZY)
	@NotBlank(message = "Flat Address must not be empty or null")
	private FlatAddress flatAddress;
	
	@NotBlank(message = "Availability must not be empty or null")
	private String availability;
	
	@JsonIgnore
	@ManyToOne(cascade = CascadeType.ALL,fetch=FetchType.LAZY)
	
	@JoinColumn(name="LANDLORD_ID")
	private Landlord landlord;
	
	
}
