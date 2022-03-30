package ru.vlapin.experiments.storypoints.service.jsonplaceholder;

import java.util.List;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import ru.vlapin.experiments.storypoints.model.jsonplaceholder.User;

@FeignClient(
    name = "UserJsonPlaceHolder",
    url = "https://jsonplaceholder.typicode.com",
    path = "users")
public interface UserService {

  @GetMapping
  List<User> all();

  @GetMapping("{id}")
  ResponseEntity<User> findById(@PathVariable Long id);
}
