package com.example.fcm.notification;

import lombok.Getter;

@Getter
public class FcmNotification {
    private Long notificationId;
    private String title;
    private String content;

    public FcmNotification(String title, String content) {
        this.title = title;
        this.content = content;
    }
}
