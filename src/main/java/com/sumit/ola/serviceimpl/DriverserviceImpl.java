package com.sumit.ola.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.sumit.ola.Exception.DriverException;
import com.sumit.ola.Exception.RideException;
import com.sumit.ola.config.jwtTokenProvider;
import com.sumit.ola.entity.Driver;
import com.sumit.ola.entity.Licance;
import com.sumit.ola.entity.Ride;
import com.sumit.ola.entity.Vechle;
import com.sumit.ola.enums.RideStatus;
import com.sumit.ola.enums.UserRole;
import com.sumit.ola.repo.DriverRepo;
import com.sumit.ola.repo.LicanceRepo;
import com.sumit.ola.repo.RideRepo;
import com.sumit.ola.repo.UserRepo;
import com.sumit.ola.repo.VechileRepo;
import com.sumit.ola.request.SignupRequestDriver;
import com.sumit.ola.service.Calculator;
import com.sumit.ola.service.DriverService;
import java.util.ArrayList;

@Service
public class DriverserviceImpl implements DriverService {

	@Autowired
	private UserRepo userepo;
	@Autowired
	private DriverRepo DriverRepo;
	@Autowired
	private BCryptPasswordEncoder encoder;
	@Autowired
	private Calculator calculator;
	@Autowired
	private jwtTokenProvider jwts;
	@Autowired
	private VechileRepo vrepo;
	@Autowired
	private LicanceRepo lrepo;
	@Autowired
	private RideRepo riderepo;
	
	
	
	@Override
	public Driver registerDriver(SignupRequestDriver driver) throws DriverException {
		
		Licance licance = driver.getLicance();
		Vechle vechle = driver.getVechle();
		
		Licance lic=new Licance();
		lic.setLicenceState(licance.getLicenceState());
		lic.setLicencenumber(licance.getLicencenumber());
		lic.setLicenceExpiredate(licance.getLicenceExpiredate());
		lic.setId(licance.getId());
		
		Licance savelicance = lrepo.save(lic);
		
		Vechle vec=new Vechle();
		vec.setMake(vechle.getMake());
		vec.setModel(vechle.getModel());
		vec.setColor(vechle.getColor());
		vec.setLicanceplate(vechle.getLicanceplate());
		vec.setSeatCapacity(vechle.getSeatCapacity());
		vec.setYear(vechle.getYear());
		vec.setId(vechle.getId());
		
		Vechle savevec = vrepo.save(vec);
		String encodepassword = encoder.encode(driver.getPassword());
		
		Driver drv=new Driver();
		drv.setEmail(driver.getEmail());
		drv.setName(driver.getName());
		drv.setMobile(driver.getMobile());
		drv.setPassword(encodepassword);
		drv.setLicance(savelicance);
		drv.setVechle(savevec);
		drv.setRole(UserRole.DRIVER);
		
		drv.setLatitude(driver.getLatitude());
		drv.setLongitude(driver.getLongitude());
		
		Driver savedriver = DriverRepo.save(drv);
		
		
		savelicance.setDriver(savedriver);
		savevec.setDriver(savedriver);
		lrepo.save(savelicance);
		vrepo.save(savevec);
		
		
		return savedriver;
	}

	@Override
	public List<Driver> getAvalibleDriver(double pickupLatitude, double pickupLongitude, double redius, Ride ride)
			throws DriverException, RideException
	{
	 
		List<Driver> allDriver = DriverRepo.findAll();
		List<Driver>availableDrivers=new ArrayList<>();
		
		for(Driver driver:allDriver)
		{
			if(driver.getCurrentRide()!=null&& driver.getCurrentRide().getRideStatus()!=RideStatus.COMPLETED)
			{
				continue;
			}
			if(ride.getDeclineDrivers().contains(driver.getId())) {
				System.out.println("its contains");
				continue;
			}
			
			double driverLatitude=driver.getLatitude();
			double driverLongitude=driver.getLongitude();
			
			double distance=calculator.calculateDistance
					(driverLongitude, pickupLatitude, pickupLongitude, redius);
			
			availableDrivers.add(driver);
			
		}
		
		
		return availableDrivers;
	}

	@Override
	public Driver findNerestDriver(List<Driver> availableDrivers, double pickupLatitude, double pickupLongitude)
			throws DriverException, RideException
	{
		 double min=Double.MAX_VALUE;;
		 Driver nerestDriver=null;
		 
		 for(Driver driver:availableDrivers) {
			 
			 double driverLatitude=driver.getLatitude();
			 double driverLongitude=driver.getLongitude();

				double distance=calculator.calculateDistance
						(driverLongitude, pickupLatitude, pickupLongitude, min);
				
				if(min>distance) {
					min=distance;
					nerestDriver=driver;
				}
				
		 }
		return nerestDriver;
	}

	@Override
	public Driver getreqDriverProfile(String jwt) throws DriverException {

		String emailFromJwt = jwts.getEmailFromJwt(jwt);
		Driver driver = DriverRepo.findByEmail(emailFromJwt);
		if(driver==null) {
			throw new DriverException("driver not exists...with this email");
			
		}
		
		
		return driver;
	}

	@Override
	public Ride getCurentRide(Integer driverId) throws DriverException {
	
		Driver driver = findDriverById(driverId);
		
		return driver.getCurrentRide();
	}

	@Override
	public List<Ride> getAllocatedRide(Integer driverId) throws DriverException {

          List<Ride>allocateRide=DriverRepo.getAllocatedRides(driverId);
          return allocateRide;

	}

	@Override
	public Driver findDriverById(Integer driverId) throws DriverException {
		Optional<Driver> findById = DriverRepo.findById(driverId);
		if(findById.isPresent()) {
			
		return 	findById.get();
		}
		throw new DriverException("Driver not found this id");
	}

	@Override
	public List<Ride> completeRides(Integer driverId) throws DriverException {
		
		List<Ride> completedRides = DriverRepo.getCompletedRides(driverId);
		return completedRides;
	}

}
