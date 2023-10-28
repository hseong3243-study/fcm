package com.example.fcm.notification.controller.request;

public record RegisterTokenRequest(Long memberId, String fcmToken) {

}
