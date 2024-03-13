package com.TrackingAPI.TrackingAPI.Service;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class TrackingService {

    private Map<String, Integer> videoReplays = new HashMap<>();


    public String updateData(String videoId, int seconds) {

        // Code to use
        // If we want to add currentSeconds or new seconds into already existing seconds saved for a videoId

//        if (videoReplays.containsKey(videoId)) {
//            int currentSeconds = videoReplays.get(videoId);
//            videoReplays.put(videoId, currentSeconds + seconds);
//            return "Data updated";
//        } else {
//            videoReplays.put(videoId, seconds);
//            return "Data inserted";
//        }

        videoReplays.put(videoId, seconds);
        return "Data inserted";
    }

    public int getReplayedSeconds(String videoId) {
        return videoReplays.getOrDefault(videoId, 0);
    }

}
