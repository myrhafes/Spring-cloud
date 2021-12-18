package org.sid;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class SpringCloudWsEurekaDiscovryApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudWsEurekaDiscovryApplication.class, args);
	}

}
