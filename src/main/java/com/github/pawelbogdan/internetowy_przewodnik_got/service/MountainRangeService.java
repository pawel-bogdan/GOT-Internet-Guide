package com.github.pawelbogdan.internetowy_przewodnik_got.service;

import com.github.pawelbogdan.internetowy_przewodnik_got.model.MountainRange;
import com.github.pawelbogdan.internetowy_przewodnik_got.model.MountainRange;
import com.github.pawelbogdan.internetowy_przewodnik_got.model.repositories.MountainRangeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MountainRangeService {
    private MountainRangeRepo mountainRangeRepo;

    @Autowired
    public MountainRangeService(MountainRangeRepo mountainRangeRepo) {
        this.mountainRangeRepo = mountainRangeRepo;
    }

    /**
     * Gets all mountain ranges from repository
     * @return list of mountain ranges
     */
    public List<MountainRange> getAllRanges() {
        return mountainRangeRepo.findAll();
    }

    /**
     * Gets mountain range with the name given in argument
     * @param name mountain range name
     * @return mountain range with the given name, if exists
     */
    public Optional<MountainRange> getRange(String name) {
        return mountainRangeRepo.findById(name);
    }

    /**
     * Adds mountain point into the database
     * @param mountainRange mountain range to add
     * @return saved mountain range
     */
    public MountainRange addMountainRange(MountainRange mountainRange) {
        return mountainRangeRepo.save(mountainRange);
    }
}
