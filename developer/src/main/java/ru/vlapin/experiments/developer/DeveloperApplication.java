package ru.vlapin.experiments.developer;

import static org.springframework.boot.SpringApplication.*;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class DeveloperApplication {

  public static void main(String[] args) {
    //noinspection resource
    run(DeveloperApplication.class, args);
  }
}
