package com.example.chatserver.config;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import jakarta.annotation.PostConstruct;
import java.io.FileInputStream;
import java.io.IOException;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FCMConfig {

    @PostConstruct
    private void init() throws IOException {
        FileInputStream serviceAccount = new FileInputStream("src/main/resources/security/Server-Security/fcm/tht-fcm-firebase-adminsdk-waqsh-7f9e6071b2.json");

        FirebaseOptions options = FirebaseOptions.builder()
            .setCredentials(GoogleCredentials.fromStream(serviceAccount))
            .build();

        FirebaseApp.initializeApp(options);
    }
}
