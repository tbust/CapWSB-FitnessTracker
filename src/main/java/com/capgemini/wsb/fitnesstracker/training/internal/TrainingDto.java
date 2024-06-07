package com.capgemini.wsb.fitnesstracker.training.internal;


import com.capgemini.wsb.fitnesstracker.user.api.User;
import com.capgemini.wsb.fitnesstracker.training.api.Training;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.annotation.Nullable;

import java.time.LocalDate;
import java.util.Date;

record TrainingDto (@Nullable Long id, User user, double distance, double averageSpeed, ActivityType activityType,
                    Date startTime,
                    Date endTime,

                    @JsonFormat(pattern = "yyyy-MM-dd") LocalDate date)
{
}
