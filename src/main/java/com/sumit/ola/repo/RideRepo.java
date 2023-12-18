package com.sumit.ola.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sumit.ola.entity.Ride;

public interface RideRepo extends JpaRepository<Ride, Integer>{

}
