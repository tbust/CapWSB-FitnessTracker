package com.capgemini.wsb.fitnesstracker.training.api;

import com.capgemini.wsb.fitnesstracker.training.internal.ActivityType;

import java.util.List;
import java.util.Optional;
import java.time.LocalDate;
public interface TrainingService {

    Training createTraining(Training training);

    List<Training> getAllTrainings();

    //List<Training> getTrainingsByUserId(Long userId);

    //List<Training> getTrainingsAfterDate(LocalDate date);

    //List<Training> getTrainingsByActivityType(ActivityType activityType);

    //Optional<Training> updateTraining(Long id, Training training);

}
