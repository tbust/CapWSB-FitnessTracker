package com.capgemini.wsb.fitnesstracker.training.internal;


import com.capgemini.wsb.fitnesstracker.training.api.Training;
import com.capgemini.wsb.fitnesstracker.training.internal.TrainingDto;

import org.springframework.stereotype.Component;


@Component
public class TrainingMapper {

    public TrainingDto toDto(Training training){
        return new TrainingDto(training.getId(),
                        training.getUser(),
                        training.getDistance(),
                        training.getAverageSpeed(),
                        training.getActivityType(),
                        training.getStartTime(),
                        training.getEndTime(),
                        training.getDate());


    }
Training toEntity (TrainingDto trainingDto) {
        return new Training(trainingDto.user(),
                trainingDto.startTime(),
                trainingDto.endTime(),
                trainingDto.activityType(),
                trainingDto.distance(),
                trainingDto.date(),
                trainingDto.averageSpeed());





}

    }





