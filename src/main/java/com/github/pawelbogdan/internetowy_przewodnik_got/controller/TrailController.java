package com.github.pawelbogdan.internetowy_przewodnik_got.controller;

import com.github.pawelbogdan.internetowy_przewodnik_got.model.Color;
import com.github.pawelbogdan.internetowy_przewodnik_got.model.Trail;
import com.github.pawelbogdan.internetowy_przewodnik_got.model.dto.TrailDTO;
import com.github.pawelbogdan.internetowy_przewodnik_got.service.TrailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import static java.util.stream.Collectors.*;

@RestController
public class TrailController {
    private final TrailService service;

    @Autowired
    public TrailController(TrailService service) {
        this.service = service;
    }

    @GetMapping("/trails")
    public ResponseEntity<List<TrailDTO>> getAllTrails() {
        return new ResponseEntity<>(service.getAllTrails().stream().map(TrailDTO::new).collect(toList()), HttpStatus.OK);
    }

    @GetMapping("/trails/{id}")
    public ResponseEntity<TrailDTO> getAllTrails(@PathVariable(value = "id") Long id) {
        return new ResponseEntity<>(new TrailDTO(service.get(id).get()), HttpStatus.OK);
    }

    @GetMapping("/trails/filtered")
    public List<TrailDTO> getFilteredTrails(@RequestParam("search") String searchPhrase, @RequestParam("start") String startingPoint,
           @RequestParam("end") String endPoint, @RequestParam("range") String mountainRange, @RequestParam("color") String color,
           @RequestParam("minPoints") Optional<Integer> minPoints, @RequestParam("maxPoints") Optional<Integer> maxPoints,
           @RequestParam("minTime") Optional<Integer> minEstimatedTime, @RequestParam("maxTime") Optional<Integer> maxEstimatedTime) {

        if(color.equals("-"))
            return service.getAllTrails(searchPhrase, startingPoint, endPoint, mountainRange,
                            minPoints.orElse(TrailService.MINIMAL_POINTS_TO_REACH), maxPoints.orElse(TrailService.MAXIMAL_POINTS_TO_REACH),
                            minEstimatedTime.orElse(TrailService.MINIMAL_ESTIMATED_TIME), maxEstimatedTime.orElse(TrailService.MAXIMAL_ESTIMATED_TIME))
                    .stream().map(TrailDTO::new).collect(toList());
        else
            return service.getAllTrails(searchPhrase, startingPoint, endPoint, mountainRange, Color.valueOf(color),
                        minPoints.orElse(TrailService.MINIMAL_POINTS_TO_REACH), maxPoints.orElse(TrailService.MAXIMAL_POINTS_TO_REACH),
                        minEstimatedTime.orElse(TrailService.MINIMAL_ESTIMATED_TIME), maxEstimatedTime.orElse(TrailService.MAXIMAL_ESTIMATED_TIME))
                .stream().map(TrailDTO::new).collect(toList());
    }

    @PostMapping("/trails")
    public ResponseEntity<TrailDTO> addTrail(@RequestParam("start") String startingPointName, @RequestParam("end") String endPointName,
                                          @RequestParam("range") String mountainRangeName, @RequestParam("color") Color color,
                                          @RequestParam("pointsReaching") Integer pointsForReaching,
                                          @RequestParam("pointsDescent") Optional<Integer> pointsForDescent,
                                          @RequestParam("time") Integer estimatedTime, @RequestParam("oneWay") Boolean oneWay) {
        Trail createdTrail = service.createTrail(startingPointName, endPointName, mountainRangeName, color,
                pointsForReaching, pointsForDescent, estimatedTime, oneWay);

        return new ResponseEntity<>(new TrailDTO(createdTrail), HttpStatus.CREATED);
    }

    @PutMapping("/trails/{id}")
    public ResponseEntity<TrailDTO> updateTrail(@PathVariable(value = "id") Long id, @RequestBody TrailDTO trail) {
        if (service.get(id).isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        Trail toUpdate = service.get(id).get();
        return new ResponseEntity<>(new TrailDTO(service.save(service.updateTo(toUpdate, trail))), HttpStatus.OK);
    }
}
