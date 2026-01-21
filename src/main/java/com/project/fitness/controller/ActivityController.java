package com.project.fitness.controller;

import com.project.fitness.dto.ActivityRequest;
import com.project.fitness.dto.ActivityResponse;
import com.project.fitness.repository.ActivityRepository;
import com.project.fitness.service.ActivityService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/activities")
@RequiredArgsConstructor
public class ActivityController {

     private final ActivityRepository activityRepository;
     private final ActivityService activityService;

    @PostMapping
    public  ResponseEntity<ActivityResponse> tackActivity(@RequestBody ActivityRequest activityRequest) {
        return ResponseEntity.ok(activityService.trackActivity(activityRequest));
    }
     @GetMapping
    public ResponseEntity<List<ActivityResponse>> getAllActivities(@RequestHeader(value ="X-User_ID") String userId) {
        return ResponseEntity.ok(activityService.getUserActivities(userId));
     }

}
