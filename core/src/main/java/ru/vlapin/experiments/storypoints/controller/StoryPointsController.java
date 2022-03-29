package ru.vlapin.experiments.storypoints.controller;

import lombok.RequiredArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.vlapin.experiments.storypoints.service.StoryPointsService;

@RestController
@RequiredArgsConstructor
public class StoryPointsController {

  StoryPointsService storyPointsService;

  @NotNull
  @GetMapping("api/sp")
  public ResponseEntity<@NotNull Integer> getStoryPoints() {
    return ResponseEntity.ok(storyPointsService.getStoryPoints());
  }
}
