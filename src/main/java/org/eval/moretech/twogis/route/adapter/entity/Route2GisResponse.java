package org.eval.moretech.twogis.route.adapter.entity;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
public class Route2GisResponse {

    private Query query;
    private List<Result> result;
    private String status;
    private String type;

    @Data
    @Builder
    @JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
    public static class Query {
        private String locale;
        private String routeMode;
        private String trafficMode;
        private String transport;
    }

    @Data
    @Builder
    @JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
    public static class Result {
        private String id;
        private String algorithm;
        private PedestrianPath beginPedestrianPath;
        private PedestrianPath endPedestrianPath;
        private List<String> filterRoadTypes;
        private List<Maneuver> maneuvers;
        private Double reliability;
        private String routeId;
        private Integer totalDistance;
        private Integer totalDuration;
        private String type;
        private UIDistance uiTotalDistance;
        private String uiTotalDuration;
        private List<Waypoint> waypoints;
    }

    @Data
    @Builder
    @JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
    public static class Maneuver {
        private String id;
        private String comment;
        private String icon;
        private Path outcomingPath;
        private String outcomingPathComment;
        private String type;
        private Integer turnAngle;
        private String turnDirection;
    }

    @Data
    @Builder
    public static class Path {
        private Integer distance;
        private Integer duration;
        private List<Geometry> geometry;
        private List<String> names;
    }

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class PedestrianPath {
        private Geometry geometry;
    }

    @Data
    @Builder
    public static class Geometry {
        private String color;
        private Integer length;
        private String selection;
        private String style;
    }

    @Data
    @Builder
    public static class UIDistance {
        private String unit;
        private String value;
    }

    @Data
    @Builder
    @JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
    public static class Waypoint {
        private Point originalPoint;
        private Point projectedPoint;
        private Boolean transit;
    }

    @Data
    @Builder
    public static class Point {
        private Double lon;
        private Double lat;
    }
}
