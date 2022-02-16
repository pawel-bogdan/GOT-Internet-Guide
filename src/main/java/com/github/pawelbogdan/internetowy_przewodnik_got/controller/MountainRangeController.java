package com.github.pawelbogdan.internetowy_przewodnik_got.controller;

import com.github.pawelbogdan.internetowy_przewodnik_got.model.MountainRange;
import com.github.pawelbogdan.internetowy_przewodnik_got.service.MountainRangeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MountainRangeController {
    private MountainRangeService service;

    @Autowired
    public MountainRangeController(MountainRangeService service) {
        this.service = service;
    }

    @GetMapping("/ranges")
    public ResponseEntity<List<MountainRange>> getAllRanges() {
        return new ResponseEntity<>(service.getAllRanges(), HttpStatus.OK);
    }

    @PostMapping("/ranges")
    public ResponseEntity<MountainRange> addMountainRange(@RequestBody MountainRange mountainRange) {
        return new ResponseEntity<>(service.addMountainRange(mountainRange), HttpStatus.CREATED);
    }
}
