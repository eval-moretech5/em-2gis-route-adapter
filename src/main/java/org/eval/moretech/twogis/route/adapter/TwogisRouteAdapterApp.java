package org.eval.moretech.twogis.route.adapter;

import org.eval.moretech.twogis.route.adapter.config.TwoGisClientProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableConfigurationProperties(TwoGisClientProperties.class)
@EnableFeignClients
public class TwogisRouteAdapterApp {

	public static void main(String[] args) {
		SpringApplication.run(TwogisRouteAdapterApp.class, args);
	}

}
