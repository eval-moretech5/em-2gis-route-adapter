package org.eval.moretech.twogis.route.adapter.controller;

import lombok.RequiredArgsConstructor;
import org.eval.moretech.twogis.route.adapter.entity.RouteRequest;
import org.eval.moretech.twogis.route.adapter.entity.RouteResponse;
import org.eval.moretech.twogis.route.adapter.service.RouteService;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/v1/routes")
@RequiredArgsConstructor
public class RouteController {

    private final RouteService routeService;

    @PostMapping
    public RouteResponse getRoutes(@RequestBody RouteRequest request) {
        return routeService.findRoute(request);
    }
}
