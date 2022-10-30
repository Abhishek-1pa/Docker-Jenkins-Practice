package com.cg.flatrental.app.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import com.cg.flatrental.app.entity.Flat;
import com.cg.flatrental.app.entity.FlatBooking;
import com.cg.flatrental.app.exception.FlatBookingNotFoundException;
import com.cg.flatrental.app.repository.IFlatBookingRepository;
import com.cg.flatrental.app.service.IFlatBookingService;



@Service
public class IFlatBookingServiceImplementation implements IFlatBookingService {

	@Autowired
	private IFlatBookingRepository iFlatBookingRepository;

	@Override
	public FlatBooking addFlatBooking(FlatBooking flatBooking) {
		iFlatBookingRepository.save(flatBooking);
		return flatBooking;
	}
	
	public FlatBooking updateFlatBooking(FlatBooking flatBooking,Long BookingId) {
		Optional<FlatBooking> fbookingid = iFlatBookingRepository.findById(BookingId);
		FlatBooking fbooking = null;
		if(!fbookingid .isPresent()) {
			throw new FlatBookingNotFoundException("FlatBooking("+BookingId+") Not Found");
		}else {
			fbooking.setFlat(flatBooking.getFlat());
			fbooking.setTenant(flatBooking.getTenant());
			fbooking.setBookingFromDate(flatBooking.getBookingFromDate());
			fbooking.setBookingToDate(flatBooking.getBookingToDate());
			iFlatBookingRepository.save(fbooking);
		}
			
		return fbooking;
	}

	public FlatBooking viewFlatBooking(Long BookingId) {
		Optional<FlatBooking> flatbooking = iFlatBookingRepository.findById(BookingId);
		if(!flatbooking.isPresent()) {
			throw new FlatBookingNotFoundException("FlatBooking("+BookingId+") Not Found");
		}
		return flatbooking.get();
	}

	public void deleteFlatBooking(Long BookingId) {
		Optional<FlatBooking> fbooking = iFlatBookingRepository.findById(BookingId);
		//FlatBooking flat = null;
		if(!fbooking .isPresent()) {
			throw new FlatBookingNotFoundException("FlatBooking("+BookingId+") Not Found");
		}else {
			iFlatBookingRepository.deleteById(BookingId);
		}
		
	}
	public List<FlatBooking> viewFlatBooking(){
		return iFlatBookingRepository.findAll();
	}

}
