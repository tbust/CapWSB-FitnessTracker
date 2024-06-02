package com.capgemini.wsb.fitnesstracker.training.internal;

import com.capgemini.wsb.fitnesstracker.training.api.Training;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
interface TrainingRepository extends JpaRepository<Training, Long> {

    default List<Training> findByUserId(Long userId) {
        return findAll().stream()
                .filter(training -> training.getUser().equals(userId))
                .collect(Collectors.toList());
    }

    default List<Training> findByDateAfter(LocalDate date) {
        return findAll().stream()
                .filter(training -> training.getDate().isAfter(date))
                .collect(Collectors.toList());
    }

    default List<Training> findByActivityType(ActivityType activityType) {
        return findAll().stream()
                //.filter(training -> training.getActivityType())
                .collect(Collectors.toList());
    }

    default Optional<Training> findById(Long id) {
        return findAll().stream()
                .filter(training -> training.getId().equals(id))
                .findFirst();
    }




}
