package com.cg.flatrental.app.service.implementation;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.flatrental.app.entity.FlatBooking;
import com.cg.flatrental.app.entity.Tenant;
import com.cg.flatrental.app.exception.FlatBookingNotFoundException;
import com.cg.flatrental.app.exception.TenantNotFoundException;
import com.cg.flatrental.app.repository.IFlatBookingRepository;
import com.cg.flatrental.app.repository.ITenantRepository;
import com.cg.flatrental.app.service.ITenantService;

@Service
public class ITenantServiceImplementation implements ITenantService {

	@Autowired
	private ITenantRepository iTenantRepository;

	public Tenant addTenant(Tenant tenant) {
		iTenantRepository.save(tenant);
		return tenant;
	}

	public Tenant updateTenant(Tenant tenant, Long tenantId) {
		Optional<Tenant> tenan = iTenantRepository.findById(tenantId);
		Tenant utenant = null;
		if (!tenan.isPresent()) {
			throw new TenantNotFoundException("Tenant(" + tenantId + ") Not Found");
		} else {
			utenant.setAge(tenant.getAge());
			utenant.setFlatAddress(tenant.getFlatAddress());
			iTenantRepository.save(utenant);
		}

		return utenant;
	}

	public Tenant viewTenant(Long tenantId) {
		Optional<Tenant> tenant = iTenantRepository.findById(tenantId);
		if (!tenant.isPresent()) {
			throw new TenantNotFoundException("Tenant(" + tenantId + ") Not Found");
		}
		return tenant.get();
	}

	public void deleteTenant(Long tenantId) {
		Optional<Tenant> tenant = iTenantRepository.findById(tenantId);

		if (!tenant.isPresent()) {
			throw new TenantNotFoundException("Tenant(" + tenantId + ") Not Found");
		} else {
			iTenantRepository.deleteById(tenantId);
		}

	}

	public List<Tenant> viewAllTenant() {
		return iTenantRepository.findAll();
	}

	public String validateTenant(Long tenantId) {

		Optional<Tenant> tenant = iTenantRepository.findById(tenantId);
		if (tenant.isPresent()) {
			return "Tenant is present";
		} else {
			return "Tenant is not present";
		}
	}
}
