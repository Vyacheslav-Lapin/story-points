package ru.vlapin.experiments.storypoints;

import static org.springframework.hateoas.config.EnableHypermediaSupport.HypermediaType.*;

import java.util.stream.Stream;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.hateoas.config.EnableHypermediaSupport;
import org.springframework.web.client.RestTemplate;
import ru.vlapin.experiments.storypoints.dao.CatRepository;
import ru.vlapin.experiments.storypoints.model.Cat;
import ru.vlapin.experiments.storypoints.model.JavaConfigBasedSetterPropertiesPlaceholderExample;
import ru.vlapin.experiments.storypoints.model.JavaConfigBasedSetterPropertiesPlaceholderExampleImpl;

@EnableFeignClients
@SpringBootApplication
@ConfigurationPropertiesScan
@EnableHypermediaSupport(type = HAL)
@ComponentScan(includeFilters = @Filter(Aspect.class))
public class StoryPointsApplication {

  public static void main(String[] args) {
    SpringApplication.run(StoryPointsApplication.class, args);
  }

  @Bean
  ApplicationRunner runner(CatRepository catRepository) {
    return __ -> Stream.of("Мурзик, Барсик, Матроскин".split(", "))
                     .map(Cat::new)
                     .forEach(catRepository::save);
  }

  @Bean
  @ConfigurationProperties("my-properties2")
  JavaConfigBasedSetterPropertiesPlaceholderExample mySetterProperties2() {
    return new JavaConfigBasedSetterPropertiesPlaceholderExampleImpl();
  }

  @Bean
  RestTemplate restTemplate() {
    return new RestTemplate();
  }
}
