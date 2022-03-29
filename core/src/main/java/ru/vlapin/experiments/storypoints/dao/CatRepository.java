package ru.vlapin.experiments.storypoints.dao;

import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import ru.vlapin.experiments.storypoints.model.Cat;

public interface CatRepository extends JpaRepository<Cat, UUID> {
}
