package org.eval.moretech.twogis.route.adapter.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "twogis")
@Data
public class TwoGisClientProperties {
    private String key;
}
