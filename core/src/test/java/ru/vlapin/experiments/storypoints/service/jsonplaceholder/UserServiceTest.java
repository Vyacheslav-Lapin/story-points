package ru.vlapin.experiments.storypoints.service.jsonplaceholder;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import ru.vlapin.experiments.storypoints.model.jsonplaceholder.Address;
import ru.vlapin.experiments.storypoints.model.jsonplaceholder.Geo;
import ru.vlapin.experiments.storypoints.model.jsonplaceholder.User;

@SpringBootTest
@RequiredArgsConstructor(onConstructor_ = @Autowired)
class UserServiceTest {

  UserService userService;

  @Test
  @SneakyThrows
  @DisplayName("Users works correctly")
  void usersWorksCorrectlyTest() {
    assertThat(userService.findById(1L)).isNotNull()
        .extracting(ResponseEntity::getBody)
        .extracting(User::getAddress)
        .extracting(Address::getGeo)
        .extracting(Geo::getLatitude, Geo::getLongitude)
        .contains(-37.3159, 81.1496);
  }
}
