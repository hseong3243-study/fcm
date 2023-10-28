package com.example.fcm.notification.controller.request;

public record SendNotificationRequest(Long memberId, String title, String content) {

}
