package ru.vlapin.experiments.developer;

import static org.springframework.boot.SpringApplication.*;

import lombok.SneakyThrows;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableEurekaClient
@SpringBootApplication
public class DeveloperApplication {

  public static void main(String[] args) {
    //noinspection resource
    run(DeveloperApplication.class, args);
  }

  @NotNull
  @SneakyThrows
  @Contract(pure = true)
  @GetMapping("sp2hh/{sp}")
  public ResponseEntity<@NotNull Integer> getSp2hhBySp(@PathVariable int sp) {
    return ResponseEntity.ok(toHours(sp));
  }

  private int toHours(int sp) {
    return sp * 2;
  }
}
