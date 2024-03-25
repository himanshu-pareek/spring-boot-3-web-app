package dev.javarush.hackathon.ordermanagement;

import dev.javarush.hackathon.ordermanagement.order.Order;
import dev.javarush.hackathon.ordermanagement.order.OrderRepository;
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

	private final OrderRepository orderRepository;

	private static final Logger log = LoggerFactory.getLogger(OrderManagementApplication.class);

    public OrderManagementApplication(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public static void main(String[] args) {
		SpringApplication.run(OrderManagementApplication.class, args);
	}

	@Bean
	CommandLineRunner runner() {
		return args -> {
			Order order = new Order(
					"Order 1",
					LocalDateTime.now().minus(1, ChronoUnit.HOURS),
					100,
					OrderStatus.CREATED
			);
			orderRepository.insert(order);
			order = new Order(
					"Order 2",
					LocalDateTime.now().minus(2, ChronoUnit.HOURS),
					120,
					OrderStatus.IN_PROGRESS
			);
			orderRepository.insert(order);
		};
	}

}
