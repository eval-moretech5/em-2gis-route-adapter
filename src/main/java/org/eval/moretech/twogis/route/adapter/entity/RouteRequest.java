package org.eval.moretech.twogis.route.adapter.entity;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class RouteRequest {

    Point from;
    Point to;

    TransportType transportType;

    @Value
    @Builder
    public static class Point {
        Double lat;
        Double lon;
    }
}
