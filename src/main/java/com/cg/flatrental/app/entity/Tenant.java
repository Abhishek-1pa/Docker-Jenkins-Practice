package com.cg.flatrental.app.entity;

import javax.persistence.CascadeType;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="Tenant")
@JsonIgnoreProperties(value = {"tenantId"}, allowGetters = true)
public class Tenant {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long tenantId;
	
	//@NotBlank(message = "Age must not be empty or null")
	private Integer age;
	
	@OneToOne(cascade=CascadeType.ALL)
	//@NotBlank(message = "Address must not be empty or null")
	@JoinColumn(name="FLAT_ADDRESS")
	private FlatAddress flatAddress;
}
