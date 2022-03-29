package ru.vlapin.experiments.developer.controller;

import lombok.RequiredArgsConstructor;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import ru.vlapin.experiments.developer.service.DeveloperService;

@RestController
@RequiredArgsConstructor
public class DeveloperController {

  DeveloperService developerService;

  @NotNull
  @Contract(pure = true)
  @GetMapping("sp2hh/{sp}")
  public ResponseEntity<@NotNull Integer> getSp2hhBySp(@PathVariable int sp) {
    return ResponseEntity.ok(developerService.toHours(sp));
  }
}
