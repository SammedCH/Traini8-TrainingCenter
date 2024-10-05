package com.traini8_TrainingCenter.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import org.springframework.stereotype.Service;

import com.traini8_TrainingCenter.entity.TrainingCenter;
import com.traini8_TrainingCenter.exceptionHandle.EmailAlreadyExistsException;
import com.traini8_TrainingCenter.repository.TrainingCenterRepository;
import com.traini8_TrainingCenter.service.TrainingCenterService;

@Service
public class TrainingCenterServiceImpl implements TrainingCenterService {
    @Autowired
    private TrainingCenterRepository trainingCenterRepository;


    @Override
    public TrainingCenter createTrainingCenter(TrainingCenter trainingCenter) {
        // Check if the email already exists
        if (trainingCenterRepository.existsByContactEmail(trainingCenter.getContactEmail())) {
            throw new EmailAlreadyExistsException("Email is already taken!");
        }
        trainingCenter.setCreatedOn(System.currentTimeMillis()); // set epoch time
        return trainingCenterRepository.save(trainingCenter);
    }
    
    @Override
    public List<TrainingCenter> getAllTrainingCenters() {
        return trainingCenterRepository.findAll();
    }
    
    // New method to get training centers by city
    @Override
    public List<TrainingCenter> getTrainingCentersByCity(String city) {
        return trainingCenterRepository.findByAddress_City(city);
    }

    // New method to get training centers by center code
    @Override
    public List<TrainingCenter> getTrainingCentersByCenterCode(String centerCode) {
        return trainingCenterRepository.findByCenterCode(centerCode);
    }
}
