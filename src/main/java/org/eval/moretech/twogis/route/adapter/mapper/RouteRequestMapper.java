package org.eval.moretech.twogis.route.adapter.mapper;

import org.eval.moretech.twogis.route.adapter.entity.Route2gisRequest;
import org.eval.moretech.twogis.route.adapter.entity.RouteRequest;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class RouteRequestMapper {

    private static final String POINT_TYPE_STOP = "stop";
    private static final String LOCALE_RU = "ru";
    private static final String ROUTE_MODE_FASTEST = "fastest";
    private static final String TRAFFIC_MODE_JAM = "jam";

    public Route2gisRequest map(RouteRequest source) {
        return Route2gisRequest.builder()
            .points(
                List.of(
                    Route2gisRequest.Point.builder()
                        .lon(source.getFrom().getLon())
                        .lat(source.getFrom().getLat())
                        .type(POINT_TYPE_STOP)
                        .build(),
                    Route2gisRequest.Point.builder()
                        .lon(source.getTo().getLon())
                        .lat(source.getTo().getLat())
                        .type(POINT_TYPE_STOP)
                        .build()
                )
            )
            .locale(LOCALE_RU)
            .transport(source.getTransportType().getValue())
            .routeMode(ROUTE_MODE_FASTEST)
            .trafficMode(TRAFFIC_MODE_JAM)
            .build();
    }
}
