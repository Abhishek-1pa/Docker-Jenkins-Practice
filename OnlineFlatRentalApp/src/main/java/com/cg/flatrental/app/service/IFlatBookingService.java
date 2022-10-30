package com.cg.flatrental.app.service;

import java.util.List;

import com.cg.flatrental.app.entity.Flat;
import com.cg.flatrental.app.entity.FlatBooking;

public interface IFlatBookingService {
	FlatBooking addFlatBooking(FlatBooking flatBooking);
	FlatBooking updateFlatBooking(FlatBooking flatBooking,Long BookingId);
	FlatBooking viewFlatBooking(Long BookingId);
	void deleteFlatBooking(Long BookingId);
	List<FlatBooking> viewFlatBooking();
	
}
