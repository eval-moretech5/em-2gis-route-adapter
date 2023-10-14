package org.eval.moretech.twogis.route.adapter.mapper;

import org.eval.moretech.twogis.route.adapter.entity.Route2GisResponse;
import org.eval.moretech.twogis.route.adapter.entity.RouteResponse;
import org.eval.moretech.twogis.route.adapter.parboiledwkt.Coordinate;
import org.eval.moretech.twogis.route.adapter.parboiledwkt.Geometry;
import org.eval.moretech.twogis.route.adapter.parboiledwkt.LineString;
import org.eval.moretech.twogis.route.adapter.parboiledwkt.WKTParser;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.parboiled.Parboiled;
import org.parboiled.parserunners.ReportingParseRunner;
import org.parboiled.support.ParsingResult;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Mapper
public abstract class RouteResponseMapper {

    private static final WKTParser parser = Parboiled.createParser(WKTParser.class);

    @Mappings({
        @Mapping(source = "result", target = "routes"),
    })
    public abstract RouteResponse map(Route2GisResponse source);

    @Mappings({
        @Mapping(source = "uiTotalDistance", target = "textDistance"),
        @Mapping(source = "uiTotalDuration", target = "textDuration"),
    })
    public RouteResponse.Route map(Route2GisResponse.Result source) {
        List<RouteResponse.Maneuver> maneuvers = new ArrayList<>();
        if (source.getBeginPedestrianPath() != null) {
            maneuvers.add( map(source.getBeginPedestrianPath()) );
        }
        if (!CollectionUtils.isEmpty(source.getManeuvers())) {
            for (Route2GisResponse.Maneuver maneuver : source.getManeuvers()) {
                maneuvers.add( map(maneuver) );
            }
        }
        if (source.getEndPedestrianPath() != null) {
            maneuvers.add( map(source.getEndPedestrianPath()) );
        }

        return RouteResponse.Route.builder()
            .distance(source.getTotalDistance())
            .textDistance( map(source.getUiTotalDistance()) )
            .duration(source.getTotalDuration())
            .textDuration(source.getUiTotalDuration())
            .maneuvers(Collections.unmodifiableList(maneuvers) )
            .build();
    };

    public String map(Route2GisResponse.UIDistance source) {
        return source.getValue() + " " + source.getUnit();
    }

    @Mappings({
        @Mapping(source = "geometry", target = "chunks"),
    })
    public RouteResponse.Maneuver map(Route2GisResponse.PedestrianPath source) {
        return RouteResponse.Maneuver.builder()
            .chunks(
                List.of( map( source.getGeometry() ) )
            )
            .type("pedestrian")
            .build();
    }

    @Mappings({
        @Mapping(source = "outcomingPathComment", target = "pathComment"),
        @Mapping(source = "outcomingPath.distance", target = "distance"),
        @Mapping(source = "outcomingPath.duration", target = "duration"),
        @Mapping(source = "outcomingPath.geometry", target = "chunks"),
    })
    public abstract RouteResponse.Maneuver map(Route2GisResponse.Maneuver source);

    @Mappings({
        @Mapping(source = "selection", target = "points"),
    })
    public abstract RouteResponse.Geometry map(Route2GisResponse.Geometry source);

    public List<RouteResponse.Point> map(String selection) {
        List<RouteResponse.Point> path = new ArrayList<>();

        ParsingResult<Geometry> result = new ReportingParseRunner(parser.WKT()).run(selection);
        Geometry geometry = result.resultValue;
        LineString line = (LineString) geometry;

        for (Coordinate coordinate : line.getCoordinates()) {
            path.add(
                RouteResponse.Point.builder()
                    .lon(coordinate.getX())
                    .lat(coordinate.getY())
                    .build()
            );
        }

        return path;
    }

}
