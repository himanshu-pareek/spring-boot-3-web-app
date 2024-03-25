package dev.javarush.hackathon.ordermanagement.order;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.asm.TypeReference;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;

@Component
public class OrdersJsonLoader implements CommandLineRunner {

    private final DBOrderRepository repository;
    private static final Logger log = LoggerFactory.getLogger(OrdersJsonLoader.class);
    private final ObjectMapper objectMapper;

    public OrdersJsonLoader(DBOrderRepository repository, ObjectMapper objectMapper) {
        this.repository = repository;
        this.objectMapper = objectMapper;
    }

    @Override
    public void run(String... args) throws Exception {
        if (this.repository.count() == 0) {
            String filename = "/data/orders.json";
            log.info("Repository is empty. Loading orders from json file ");
            try (InputStream inputStream = TypeReference.class.getResourceAsStream(filename)) {
                Orders orders = objectMapper.readValue(inputStream, Orders.class);
                log.info("Reading {} orders from JSON data and saving to database", orders.orders().size());
                this.repository.saveAll(orders.orders());
                log.info("Saved {} orders to the database.", orders.orders().size());
            } catch (IOException e) {
                throw new RuntimeException("Failed to read JSON data", e);
            }
        } else {
            log.info("Repository is not empty. Skipping loading orders.");
        }
    }
}
