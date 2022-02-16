package com.github.pawelbogdan.internetowy_przewodnik_got.model.repositories;

import com.github.pawelbogdan.internetowy_przewodnik_got.model.MountainRange;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MountainRangeRepo extends JpaRepository<MountainRange, String> {
}
