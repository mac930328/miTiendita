package com.mac.tiendita;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties
@EntityScan(basePackages = {"com.mac.tiendita.modelos"})
public class TienditaApplication {

	public static void main(String[] args) {
		SpringApplication.run(TienditaApplication.class, args);
	}

}
