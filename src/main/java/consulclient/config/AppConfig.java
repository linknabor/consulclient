package consulclient.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients(basePackages={"consulclient"})
@ComponentScan("consulclient")
public class AppConfig {


	public static void main(String[] args) {
		SpringApplication.run(AppConfig.class, args);
	}

}