package com.TrackingAPI.TrackingAPI.Controller;

import com.TrackingAPI.TrackingAPI.Service.TrackingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class TrackingController {

    TrackingService trackingService;

    @Autowired
    public TrackingController(TrackingService trackingService) {
        this.trackingService = trackingService;
    }


    @PostMapping("/track-replay")
    public String trackReplay(@RequestParam String videoId, @RequestParam int seconds) {
        return trackingService.updateData(videoId, seconds);
    }

    @GetMapping("/replay-seconds")
    public String getReplayedSeconds(@RequestParam String videoId) {
        int replayedSeconds = trackingService.getReplayedSeconds(videoId);
        if (replayedSeconds == 0) {
            return "No replayed seconds found for video ID - " + videoId;
        } else {
            return "Replayed seconds for video ID - " + videoId + " : " + replayedSeconds;
        }
    }
}
