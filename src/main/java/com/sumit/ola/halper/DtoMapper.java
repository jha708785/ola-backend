package com.sumit.ola.halper;

import org.hibernate.service.spi.Stoppable;

import com.sumit.ola.dto.DriverDto;
import com.sumit.ola.dto.LicanceDto;
import com.sumit.ola.dto.RideDto;
import com.sumit.ola.dto.UserDto;
import com.sumit.ola.entity.Driver;
import com.sumit.ola.entity.Licance;
import com.sumit.ola.entity.Ride;
import com.sumit.ola.entity.User;

public class DtoMapper {

	
	public static DriverDto toDriverDto(Driver driver) {
		
		DriverDto dto=new DriverDto();
		
		dto.setId(driver.getId());
		dto.setEmail(driver.getEmail());
		dto.setLatitude(driver.getLatitude());
		dto.setLongitude(driver.getLongitude());
		dto.setMobile(driver.getMobile());
		dto.setRole(driver.getRole());
		dto.setName(driver.getName());
		dto.setVechle(driver.getVechle());
		return dto;
		
	}
	
    public static UserDto toUserDto(User user) {
    	
    	UserDto dto=new UserDto();
    	
    	dto.setId(user.getId());
    	dto.setEmail(user.getEmail());
    	dto.setMobile(user.getMobile());
    	dto.setName(user.getFullName());
    	return dto;
    }
    

    public static LicanceDto toLicanceDto(Licance li) {
    	
    	LicanceDto dto=new LicanceDto();
    	
    	dto.setLicenceExpiredate(li.getLicenceExpiredate());
    	dto.setLicencenumber(dto.getLicencenumber());
    	
    	return dto;
    }
    
    
 public static RideDto toRideDto(Ride ride) {
    	
	 DriverDto driverDto=toDriverDto(ride.getDriver());
	 
	 UserDto userDto=toUserDto(ride.getUser());
	 RideDto dto=new RideDto();
    	
    	dto.setId(ride.getId());
    	dto.setDestanitionLatitude(ride.getDestanitionLatitude());
    	dto.setDestanitionLongitude(ride.getDestanitionLongitude());
    	dto.setDistance(ride.getDistance());
    	dto.setDriver(driverDto);
    	dto.setUser(userDto);
    	dto.setDuration(ride.getDuration());
    	dto.setEndrideTime(ride.getEndrideTime());
    	dto.setFare(ride.getFare());
    	dto.setStartrideTime(ride.getStartrideTime());
    	dto.setRideStatus(ride.getRideStatus());
    	dto.setOtp(ride.getOtp());
    	dto.setPickupArea(ride.getPickupArea());
    	dto.setPickupLatitude(ride.getPickupLatitude());
    	dto.setPickupLongitude(ride.getPickupLongitude());
    
    	
    	return dto;
    }
}



