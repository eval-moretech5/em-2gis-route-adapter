package org.eval.moretech.twogis.route.adapter.repository;

import org.eval.moretech.twogis.route.adapter.entity.Route2GisResponse;
import org.eval.moretech.twogis.route.adapter.entity.Route2gisRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "2gisRoutesApi", url = "${twogis.url}")
public interface RouteClient {

    @PostMapping
    Route2GisResponse getRoutes(@RequestParam String key, @RequestBody Route2gisRequest request);
}
