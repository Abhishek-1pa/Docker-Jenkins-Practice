package com.cg.flatrental.app.entity;

import java.time.LocalDate;

import javax.persistence.CascadeType;
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
@Table(name="FLAT_BOOKING_TABLE")
@JsonIgnoreProperties(value = {"bookingNo"}, allowGetters = true)
public class FlatBooking {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long bookingNo;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="FLAT_ID")
	@NotBlank(message = "Flat must not be empty or null")
	private Flat flat;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="TENANT_ID")
	@NotBlank(message = "Tenant must not be empty or null")
	private Tenant tenant;
	
	@NotBlank(message = "Booking From Date must not be empty or null")
	private LocalDate bookingFromDate;
	
	@NotBlank(message = "Booking To Date must not be empty or null")
	private LocalDate bookingToDate;
}
