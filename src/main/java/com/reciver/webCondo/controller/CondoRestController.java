package com.reciver.webCondo.controller;

import com.reciver.webCondo.model.NotificationModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.reciver.webCondo.repository.NotificationRepository;

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

        notificationRepository.save(new NotificationModel(api_version, notification_token));

        return new ResponseEntity<>("OK", HttpStatus.OK);
    }

}
