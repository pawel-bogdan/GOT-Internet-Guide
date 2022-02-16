package com.github.pawelbogdan.internetowy_przewodnik_got.service;

import com.github.pawelbogdan.internetowy_przewodnik_got.model.MountainChain;
import com.github.pawelbogdan.internetowy_przewodnik_got.model.repositories.MountainChainRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MountainChainService {
    private final MountainChainRepo mountainChainRepo;

    @Autowired
    public MountainChainService(MountainChainRepo mountainChainRepo) {
        this.mountainChainRepo = mountainChainRepo;
    }

    /**
     * Gets all mountain chains from database
     * @return list of mountain chains
     */
    public List<MountainChain> getAllChains() {
        return mountainChainRepo.findAll();
    }

    /**
     * Adds mountain chain into the database
     * @param mountainChain mountain chain to add
     * @return saved mountain chain
     */
    public MountainChain addMountainChain(MountainChain mountainChain) {
        return mountainChainRepo.save(mountainChain);
    }
}
