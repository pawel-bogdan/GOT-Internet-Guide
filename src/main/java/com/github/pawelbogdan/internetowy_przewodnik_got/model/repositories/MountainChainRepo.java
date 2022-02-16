package com.github.pawelbogdan.internetowy_przewodnik_got.model.repositories;

import com.github.pawelbogdan.internetowy_przewodnik_got.model.MountainChain;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MountainChainRepo extends JpaRepository<MountainChain, String> {
}
