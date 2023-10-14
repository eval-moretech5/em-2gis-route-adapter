package org.eval.moretech.twogis.route.adapter.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.eval.moretech.twogis.route.adapter.config.TwoGisClientProperties;
import org.eval.moretech.twogis.route.adapter.entity.Route2GisResponse;
import org.eval.moretech.twogis.route.adapter.entity.RouteRequest;
import org.eval.moretech.twogis.route.adapter.entity.RouteResponse;
import org.eval.moretech.twogis.route.adapter.mapper.RouteRequestMapper;
import org.eval.moretech.twogis.route.adapter.mapper.RouteResponseMapper;
import org.eval.moretech.twogis.route.adapter.repository.RouteClient;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class RouteService {

    private final TwoGisClientProperties properties;
    private final RouteRequestMapper routeRequestMapper;
    private final RouteResponseMapper routeResponseMapper;
    private final RouteClient routeClient;

    public RouteResponse findRoute(RouteRequest routeRequest) {

        Route2GisResponse gisResponse = routeClient.getRoutes(properties.getKey(), routeRequestMapper.map(routeRequest));

        RouteResponse response = routeResponseMapper.map(gisResponse);

        return response;
    }
}
