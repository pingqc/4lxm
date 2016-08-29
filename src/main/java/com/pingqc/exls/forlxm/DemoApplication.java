package com.pingqc.exls.forlxm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.data.convert.Jsr310Converters;

@SpringBootApplication
@EnableCaching
@EntityScan(basePackageClasses = {DemoApplication.class, Jsr310Converters.class})
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
}