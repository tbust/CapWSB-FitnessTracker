package com.capgemini.wsb.fitnesstracker.training.internal;

import com.capgemini.wsb.fitnesstracker.training.api.Training;
import lombok.RequiredArgsConstructor;
import org.springframework.data.geo.Distance;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.util.List;
import java.util.Date;

@RestController
@RequestMapping("/v1/trainings")
@RequiredArgsConstructor
class TrainingController {

    private final TrainingServiceImpl trainingService;

    private final TrainingMapper trainingMapper;


@GetMapping
    public List<TrainingDto> getAllTrainings() {

    return trainingService.getAllTrainings()
            .stream()
            .map(trainingMapper::toDto)
            .toList();
}

@GetMapping("/{id}")

public List<TrainingDto> getTrainingByUserId(@PathVariable("id") Long id){
    return trainingService.getTrainingByUserId(id).stream().map(trainingMapper::toDto).toList();
}
@GetMapping("/by-date")
public List<TrainingDto> getTrainingsByDate(@PathVariable("date") LocalDate date){
    return trainingService.getTrainingByDate(date).stream().map(trainingMapper::toDto).toList();
}

@GetMapping("/by-activity")

    public List<TrainingDto> getTrainingByActivity(@PathVariable("activity_type") ActivityType activityType){
    return trainingService.getTrainingsByActivity(activityType).stream().map(trainingMapper::toDto).toList();
}

@PostMapping("/{start_time}/{end_time}/{distance}/{average_speed}")
    public void addTrainingtoDB(@PathVariable("start_time") Date startTime ,
                                @PathVariable("end_time") Date endTime,
                                @PathVariable("distance") double distance,
                                @PathVariable("average_speed") double averageSpeed) {

    Training training = new Training(endTime,startTime,distance,averageSpeed);
    trainingService.createTraining(training);
}

}
