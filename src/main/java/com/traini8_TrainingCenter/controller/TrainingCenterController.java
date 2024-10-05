package com.traini8_TrainingCenter.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import com.traini8_TrainingCenter.entity.TrainingCenter;
import com.traini8_TrainingCenter.service.TrainingCenterService;

import java.util.ArrayList;
import java.util.List;


/**
 * Controller for managing Training Centers.
 * Provides REST API end-points for creating and retrieving training centers.
 */
@RestController
@RequestMapping("/api/training-centers")
public class TrainingCenterController {
//    @Autowired
    private TrainingCenterService trainingCenterService;
    
    public TrainingCenterController(TrainingCenterService trainingCenterService) {
    	this.trainingCenterService = trainingCenterService;
    }

	@PostMapping
    public ResponseEntity<?> createTrainingCenter(@RequestBody @Validated TrainingCenter trainingCenter) {
        // Create a new TrainingCenter and save it to the database
        TrainingCenter newTrainingCenter = trainingCenterService.createTrainingCenter(trainingCenter);
        // Return the newly created TrainingCenter with a created status
        return ResponseEntity.status(HttpStatus.CREATED).body(newTrainingCenter);
    }

    /**
     * Retrieves a list of training centers, optionally filtered by city or center code.
     *
     * @param city optional city filter
     * @param centerCode optional center code filter
     * @return a list of training centers
     */
    //Get all training centers: GET /api/training-centers
    //Filter by city: GET /api/training-centers?city=SomeCity
    //Filter by center code: GET /api/training-centers?centerCode=ABC12345678
    @GetMapping
    public ResponseEntity<List<TrainingCenter>> getAllTrainingCenters(
            @RequestParam(required = false) String city,
            @RequestParam(required = false) String centerCode) {
        
        List<TrainingCenter> trainingCenters=new ArrayList<>();
        
        // Filter by city if provided
        if (city != null && !city.isEmpty()) {
            trainingCenters = trainingCenterService.getTrainingCentersByCity(city);
        } 
        // Filter by center code if provided
        else if (centerCode != null && !centerCode.isEmpty()) {
            trainingCenters = trainingCenterService.getTrainingCentersByCenterCode(centerCode);
        } 
        // If no filters, get all training centers
        else {
            trainingCenters = trainingCenterService.getAllTrainingCenters();
        }

        return new ResponseEntity<>(trainingCenters, HttpStatus.OK);
    }
}
