package org.eval.moretech.twogis.route.adapter.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum TransportType {
    CAR("car"),
    WALK("pedestrian"),
    SCOOTER("bicycle");

    private final String value;
}
