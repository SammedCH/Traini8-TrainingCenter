package com.traini8_TrainingCenter.service;

import java.util.List;

import com.traini8_TrainingCenter.entity.TrainingCenter;

public interface TrainingCenterService {
    TrainingCenter createTrainingCenter(TrainingCenter trainingCenter);
    List<TrainingCenter> getAllTrainingCenters();
	List<TrainingCenter> getTrainingCentersByCity(String city);
	List<TrainingCenter> getTrainingCentersByCenterCode(String centerCode);
}
