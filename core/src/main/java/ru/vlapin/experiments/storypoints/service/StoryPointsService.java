package ru.vlapin.experiments.storypoints.service;

import static lombok.AccessLevel.*;
import static org.springframework.http.HttpMethod.*;

import java.util.Objects;
import java.util.Random;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.experimental.FieldDefaults;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

public sealed interface StoryPointsService {
  @NotNull Integer getStoryPoints();
}

//@Data
//@ConstructorBinding
@Service
@RequiredArgsConstructor
//@ConfigurationProperties("story-points-service")
//@FieldDefaults(makeFinal = false, level = PRIVATE)
final class StoryPointsServiceImpl implements StoryPointsService {

  int[] storyPointVariants = {1, 2, 3, 8, 18, 80};

  final RestTemplate restTemplate;

  final Random random = new Random();

  @SneakyThrows
  public @NotNull Integer getStoryPoints() {

    int storyPointVariant = storyPointVariants[
        random.nextInt(storyPointVariants.length)];

    return Objects.requireNonNull(
        restTemplate.getForEntity(
            "http://localhost:8080/sp2hh/%d".formatted(storyPointVariant),
            Integer.class)
            .getBody());
  }
}
