package com.project.fitness.controller;

import com.project.fitness.dto.ActivityRequest;
import com.project.fitness.dto.ActivityResponse;
import com.project.fitness.repository.ActivityRepository;
import com.project.fitness.service.ActivityService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/activities")
@RequiredArgsConstructor
public class ActivityController {

     private final ActivityRepository activityRepository;
     private final ActivityService activityService;

    @PostMapping
    public ActivityResponse tackActivity(@RequestBody ActivityRequest activityRequest) {

        return activityService.trackActivity(activityRequest);
    }

}
