package ru.vlapin.experiments.developer.service;

import org.springframework.stereotype.Service;

@Service
public class DeveloperService {
  public int toHours(int sp) {
    return sp * 2;
  }
}
