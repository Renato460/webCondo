package com.reciver.webCondo.controller;

import com.reciver.webCondo.model.Notification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.reciver.webCondo.repository.NotificationRepository;

import java.util.LinkedHashMap;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class CondoRestController {

    @Autowired
    NotificationRepository notificationRepository;

    @RequestMapping(path = "/notification", method = RequestMethod.POST)
    public ResponseEntity <Object> notification (@RequestParam String api_version, @RequestParam String notification_token){
        if (api_version.isEmpty() || notification_token.isEmpty()){
            return new ResponseEntity<>("Missing Data", HttpStatus.BAD_REQUEST);
        }

        notificationRepository.save(new Notification(api_version, notification_token));

        return new ResponseEntity<>("OK", HttpStatus.OK);
    }

    @RequestMapping(path = "/get", method = RequestMethod.GET)
    public ResponseEntity<Map<String,Object>> getNotification (){
        return new ResponseEntity<>(notificationDTO(),HttpStatus.OK);
    }

    private Map<String,Object> notificationDTO (){
        Map<String,Object> dto = new LinkedHashMap<>();
        dto.put("notifications",notificationRepository.findAll());

        return dto;
    }
}
