package org.eval.moretech.twogis.route.adapter.entity;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Builder;
import lombok.Value;

import java.util.List;

@Value
@Builder
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class Route2gisRequest {

    List<Point> points;

    String locale;
    String transport;
    String routeMode;
    String trafficMode;

    @Value
    @Builder
    @JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
    public static class Point {
        String type;
        Double lon;
        Double lat;
        String objectId;
    }
}
