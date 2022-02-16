package com.github.pawelbogdan.internetowy_przewodnik_got.controller;

import com.github.pawelbogdan.internetowy_przewodnik_got.model.MountainPoint;
import com.github.pawelbogdan.internetowy_przewodnik_got.model.dto.MountainPointDTO;
import com.github.pawelbogdan.internetowy_przewodnik_got.service.MountainPointService;
import com.github.pawelbogdan.internetowy_przewodnik_got.service.MountainRangeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static java.util.stream.Collectors.*;

@RestController
public class MountainPointController {
    private final MountainPointService mountainPointService;
    private final MountainRangeService mountainRangeService;

    @Autowired
    public MountainPointController(MountainPointService mountainPointService, MountainRangeService mountainRangeService) {
        this.mountainPointService = mountainPointService;
        this.mountainRangeService = mountainRangeService;
    }

    @GetMapping(value = "/points")
    public ResponseEntity<List<MountainPointDTO>> getMountainPoints() {
        return new ResponseEntity<>(mountainPointService.getAllPoints().stream().map(MountainPointDTO::new).collect(toList()), HttpStatus.OK);
    }

    @GetMapping(value = "/points", params = "range")
    public ResponseEntity<List<MountainPointDTO>> getMountainPoints(@RequestParam("range") String range) {
        var mountainRange = mountainRangeService.getRange(range);
        if(mountainRange.isEmpty())
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        else {
            return new ResponseEntity<>(mountainPointService.getAllPoints(mountainRange.get()).stream().map(MountainPointDTO::new).collect(toList()), HttpStatus.OK);
        }

    }

    @PostMapping("/points")
    public ResponseEntity<MountainPoint> addMountainPoint(@RequestBody MountainPoint mountainPoint) {
        return new ResponseEntity<>(mountainPointService.addMountainPoint(mountainPoint), HttpStatus.CREATED);
    }

    @PutMapping("/points/{name}")
    public ResponseEntity<MountainPoint> updateMountainPoint(@PathVariable(value = "name") String name,
                                                             @RequestBody MountainPoint newMountainPoint) {
        return new ResponseEntity<>(mountainPointService.updateMountainPoint(newMountainPoint, name), HttpStatus.OK);
    }

}
