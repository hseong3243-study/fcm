package com.example.fcm.notification.service;

import com.example.fcm.member.Member;
import com.example.fcm.member.repository.MemberRepository;
import com.google.firebase.messaging.FirebaseMessaging;
import com.google.firebase.messaging.FirebaseMessagingException;
import com.google.firebase.messaging.Message;
import com.google.firebase.messaging.Notification;
import java.util.NoSuchElementException;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@RequiredArgsConstructor
public class NotificationService {

    private final FirebaseMessaging firebaseMessaging;
    private final MemberRepository memberRepository;

    @Transactional
    public void registerFcmToken(Long memberId, String token) {
        Member member = findMember(memberId);
        member.updateFcmToken(token);
        log.info("회원의 fcm 토큰이 등록되었습니다.");
    }

    @Transactional(readOnly = true)
    public void sendNotification(Long memberId, String title, String content) {
        Member member = findMember(memberId);
        Notification notification = Notification.builder()
            .setTitle(title)
            .setBody(content)
            .build();
        Message message = Message.builder()
            .setToken(member.getFcmToken())
            .setNotification(notification)
            .build();

        try {
            firebaseMessaging.send(message);
        } catch (FirebaseMessagingException ex) {
            log.info("알림 전송에 실패했습니다.");
        }
    }

    private Member findMember(Long memberId) {
        return memberRepository.findById(memberId)
            .orElseThrow(() -> new NoSuchElementException("존재하지 않는 회원입니다."));
    }
}
