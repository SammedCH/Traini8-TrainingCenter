package com.traini8_TrainingCenter.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.traini8_TrainingCenter.entity.TrainingCenter;

public interface TrainingCenterRepository extends JpaRepository<TrainingCenter, Long>{

	 boolean existsByContactEmail(String contactEmail);
	 
	    // Custom query method to find by city
	    List<TrainingCenter> findByAddress_City(String city);

	    // Custom query method to find by center code
	    List<TrainingCenter> findByCenterCode(String centerCode);


}
