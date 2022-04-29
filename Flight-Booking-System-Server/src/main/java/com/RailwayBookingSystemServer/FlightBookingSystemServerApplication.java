package com.RailwayBookingSystemServer;

import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableEurekaServer
public class FlightBookingSystemServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(FlightBookingSystemServerApplication.class, args);
	}

}
