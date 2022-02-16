package com.github.pawelbogdan.internetowy_przewodnik_got.controller;

import com.github.pawelbogdan.internetowy_przewodnik_got.model.dto.RouteDTO;
import com.github.pawelbogdan.internetowy_przewodnik_got.service.MountainPointService;
import com.github.pawelbogdan.internetowy_przewodnik_got.service.RouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class RouteController {
    private RouteService routeService;

    @Autowired
    public RouteController(RouteService routeService) {
        this.routeService = routeService;
    }

    /**
     * @param startingPointName name of starting point. Generated routes will have this point as the beginning.
     * @param endPointName name of end point. Generated routes will have this point as the end.
     * @param intermediatePointsNames names of intermediate points. Intermediate points are between start point and end point.
     * @param plannedStart planned date of starting the route.
     * @return Response entity containing list of two(the shortest one, and alternative) generated routes with 200 status code,
     *          if those routes don't exist list contains nulls.
     */
    @GetMapping("/generate")
    public ResponseEntity<List<RouteDTO>> getRoutes(@RequestParam("start") String startingPointName, @RequestParam("end") String endPointName,
                                                    @RequestParam("stops") Collection<String> intermediatePointsNames,
                                                    @RequestParam("date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime plannedStart) {

        var generatedRoutes = routeService.generateRoutes(startingPointName, endPointName,
                intermediatePointsNames, plannedStart);

        if(generatedRoutes.isPresent())
            return new ResponseEntity<>(generatedRoutes.get().stream()
                    .map(route -> new RouteDTO(route)).collect(Collectors.toList()), HttpStatus.OK);

        ArrayList<RouteDTO> dummyResult = new ArrayList<>(2); dummyResult.add(null); dummyResult.add(null);

        return new ResponseEntity(dummyResult, HttpStatus.OK);
    }
}
