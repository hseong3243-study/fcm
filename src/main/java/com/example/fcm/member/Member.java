package com.example.fcm.member;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.util.Objects;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long memberId;

    private String name;
    private String fcmToken;

    public Member(String name) {
        this.name = name;
    }

    public void updateFcmToken(String fcmToken) {
        if(Objects.nonNull(fcmToken)) {
            this.fcmToken = fcmToken;
        }
    }
}
