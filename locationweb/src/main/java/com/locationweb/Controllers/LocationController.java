package com.locationweb.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.locationweb.Services.LocationService;
import com.locationweb.entities.Location;

@Controller
public class LocationController {
	
	@Autowired
	private LocationService locationService;
	// handler methods
	
	@RequestMapping("/show")
	public String showLocationPage() {
		
		
		return "create_location";	
		}
	
	//dto
	@RequestMapping("/saveLocation")
	public String saveLocationData(@ModelAttribute("loc")Location location, ModelMap model) {
		locationService.saveLocation(location);
		model.addAttribute("msg","location is saved!!");
		return "create_location" ;
	}
	
	//@RequestMapping("/saveLocation")
	//public String saveLocationData(@RequestParam ("id")long id,@RequestParam ("name") String name,@RequestParam ("code")String code,@RequestParam("type")String type) {
	//    Location location =new Location();
	//    location.setId(id);
	 //   location.setCode(code);
	 //   location.setName(name);
	//    location.setType(type);
	//	return "create_location"; 
	//}
	
	
	
	

}
