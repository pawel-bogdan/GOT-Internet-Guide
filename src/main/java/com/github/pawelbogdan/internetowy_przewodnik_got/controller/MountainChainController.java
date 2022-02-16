package com.github.pawelbogdan.internetowy_przewodnik_got.controller;

import com.github.pawelbogdan.internetowy_przewodnik_got.model.MountainChain;
import com.github.pawelbogdan.internetowy_przewodnik_got.service.MountainChainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MountainChainController {
    private MountainChainService service;

    @Autowired
    public MountainChainController(MountainChainService service) {
        this.service = service;
    }

    @GetMapping("/chains")
    public ResponseEntity<List<MountainChain>> getAllChains() {
        return new ResponseEntity<>(service.getAllChains(), HttpStatus.OK);
    }

    @PostMapping("/chains")
    public ResponseEntity<MountainChain> addMountainChain(@RequestBody MountainChain mountainChain) {
        return new ResponseEntity<>(service.addMountainChain(mountainChain), HttpStatus.CREATED);
    }
}
