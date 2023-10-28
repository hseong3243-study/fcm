package com.example.fcm.notification.controller;

import com.example.fcm.notification.controller.request.RegisterTokenRequest;
import com.example.fcm.notification.controller.request.SendNotificationRequest;
import com.example.fcm.notification.service.NotificationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class NotificationController {

    private final NotificationService notificationService;

    @PostMapping("/register")
    public void registerToken(@RequestBody RegisterTokenRequest request) {
        notificationService.registerFcmToken(request.memberId(), request.fcmToken());
    }

    @PostMapping("/send")
    public void sendNotification(@RequestBody SendNotificationRequest request) {
        notificationService.sendNotification(request.memberId(), request.title(), request.content());
    }
}
