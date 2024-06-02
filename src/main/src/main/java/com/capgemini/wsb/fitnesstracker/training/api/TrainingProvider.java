package com.capgemini.wsb.fitnesstracker.training.api;

import com.capgemini.wsb.fitnesstracker.training.internal.ActivityType;
import com.capgemini.wsb.fitnesstracker.user.api.User;
import com.capgemini.wsb.fitnesstracker.training.api.Training;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.time.LocalDate;
public interface TrainingProvider {

    List<Training> getAllTrainings();

    List<Training> getTrainingByUserId(Long userId);

    List<Training> getTrainingByDate(LocalDate date);



    List<Training> getTrainingsByActivity(ActivityType activityType);

    Training updateTraining(Long id, Training updatedTraining);

    /**
     * Retrieves a training based on their ID.
     * If the user with given ID is not found, then {@link Optional#empty()} will be returned.
     *
     * @param trainingId id of the training to be searched
     * @return An {@link Optional} containing the located Training, or {@link Optional#empty()} if not found
     */
    Optional<User> getTraining(Long trainingId);


    //List<Training> findAllTrainings();
    //List<Training> findTrainingByUserId(Long userId);

    //List<Training> findTrainingByDate(LocalDate date);

    //List<Training> findTrainingByActivity (ActivityType activityType);

    //Optional<Training> findById (Long id);







}
