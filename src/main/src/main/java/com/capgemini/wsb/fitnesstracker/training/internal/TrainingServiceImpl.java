package com.capgemini.wsb.fitnesstracker.training.internal;

import com.capgemini.wsb.fitnesstracker.training.api.TrainingProvider;
import com.capgemini.wsb.fitnesstracker.training.api.TrainingService;
import com.capgemini.wsb.fitnesstracker.user.api.User;
import com.capgemini.wsb.fitnesstracker.training.api.Training;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor
@Slf4j
public class TrainingServiceImpl implements TrainingProvider, TrainingService {



    private final TrainingRepository trainingRepository;


    @Override
    public Training createTraining(final Training training){
        log.info("Creating training{}", training);
        if (training.getId() != null){
            throw new IllegalArgumentException("Update not permitted");
        }

        return trainingRepository.save(training);
    }


    @Override
    public List<Training> getAllTrainings() {return trainingRepository.findAll();}

    @Override
    public List<Training> getTrainingByUserId(Long userId) {return trainingRepository.findByUserId(userId);}

    @Override
    public List<Training> getTrainingByDate(LocalDate date) {return trainingRepository.findByDateAfter(date);}

    @Override
    public List<Training> getTrainingsByActivity(ActivityType activityType) {return trainingRepository.findByActivityType(activityType);}

    @Override

    public Training updateTraining(Long id, Training updatedTraining){
        return trainingRepository.findById(id)
                .map(training -> {

                    training.setStartTime(updatedTraining.getStartTime());
                    training.setEndTime(updatedTraining.getEndTime());
                    training.setActivityType(updatedTraining.getActivityType());
                    training.setUser(updatedTraining.getUser());
                    training.setAverageSpeed(updatedTraining.getAverageSpeed());
                    training.setDistance(updatedTraining.getDistance());
                    training.setDate(updatedTraining.getDate());
                    return trainingRepository.save(training);
                })
                .orElseGet(() -> {

                    updatedTraining.setId(id);
                    return trainingRepository.save(updatedTraining);
                });


    }











    @Override
    public Optional<User> getTraining(final Long trainingId) {
        throw new UnsupportedOperationException("Not finished yet");
    }

}
