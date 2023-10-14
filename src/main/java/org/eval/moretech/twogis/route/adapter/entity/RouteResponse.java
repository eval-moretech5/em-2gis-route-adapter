package org.eval.moretech.twogis.route.adapter.entity;

import lombok.Builder;
import lombok.Value;

import java.util.List;

@Value
@Builder
public class RouteResponse {

    String status;
    List<Route> routes;

    @Value
    @Builder
    public static class Route {
        String textDistance;
        Integer distance;
        String textDuration;
        Integer duration;
        List<Maneuver> maneuvers;
    }

    @Value
    @Builder
    public static class Maneuver {
        String type;
        String comment;
        String pathComment;
        Integer distance;
        Integer duration;
        List<Geometry> chunks;
    }

    @Value
    @Builder
    public static class Geometry {
        String color;
        List<Point> points;
    }


    @Value
    @Builder
    public static class Point {
        Double lon;
        Double lat;
    }
}
