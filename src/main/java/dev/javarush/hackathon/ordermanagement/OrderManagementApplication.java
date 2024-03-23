package dev.javarush.hackathon.ordermanagement;

import dev.javarush.hackathon.ordermanagement.order.Order;
import dev.javarush.hackathon.ordermanagement.order.OrderStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;

@SpringBootApplication
public class OrderManagementApplication {

	private static final Logger log = LoggerFactory.getLogger(OrderManagementApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(OrderManagementApplication.class, args);
	}

	@Bean
	CommandLineRunner runner() {
		return args -> {
			Order order = new Order(
					1,
					"Order 1",
					LocalDateTime.now().minus(1, ChronoUnit.HOURS),
					100,
					OrderStatus.CREATED
			);
			log.info("Order - " + order);
		};
	}

}
