package com.locationweb.Services.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.locationweb.Repositories.LocationRepository;
import com.locationweb.Services.LocationService;
import com.locationweb.entities.Location;

@Service
public class LocationServiceImpl implements LocationService {
	
	@Autowired
	private LocationRepository locationRepo;

	@Override
	public void saveLocation(Location location) {
		
		locationRepo.save(location);
		
		
	}

}
