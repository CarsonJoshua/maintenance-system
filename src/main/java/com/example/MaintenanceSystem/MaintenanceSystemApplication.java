package com.example.MaintenanceSystem;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Objects;

@SpringBootApplication
public class MaintenanceSystemApplication {


	public static void main(String[] args) throws IOException {
		FileInputStream serviceAccount =
				new FileInputStream(
						Objects.requireNonNull(
										MaintenanceSystemApplication.class.getClassLoader()
												.getResource("serviceAccountKey.json")
								)
								.getFile()
				);

		FirebaseOptions options = new FirebaseOptions.Builder()
				.setCredentials(GoogleCredentials.fromStream(serviceAccount))
				.build();

		FirebaseApp.initializeApp(options);
		SpringApplication.run(MaintenanceSystemApplication.class, args);
	}

}
