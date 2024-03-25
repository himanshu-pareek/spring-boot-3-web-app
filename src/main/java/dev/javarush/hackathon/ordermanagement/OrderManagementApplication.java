package dev.javarush.hackathon.ordermanagement;

import dev.javarush.hackathon.ordermanagement.order.DBOrderRepository;
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

@SpringBootApplication
public class OrderManagementApplication {

    public static void main(String[] args) {
		SpringApplication.run(OrderManagementApplication.class, args);
	}
}
