package com.example.chatserver.config;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

import java.io.IOException;

@Slf4j
@Configuration
public class FCMConfig {

    @PostConstruct
    private void init() throws IOException {

        String fileResourceURL = "security/Server-Security/fcm/tht-push-fcm-firebase-adminsdk-secretkey.json";
        ClassPathResource resource = new ClassPathResource(fileResourceURL);

        FirebaseOptions options = FirebaseOptions.builder()
            .setCredentials(GoogleCredentials.fromStream(resource.getInputStream()))
            .build();

        FirebaseApp.initializeApp(options);

        log.info("FCM Setting and Connect complete");
    }
}
