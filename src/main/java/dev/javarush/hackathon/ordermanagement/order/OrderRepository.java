package dev.javarush.hackathon.ordermanagement.order;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class OrderRepository {

    private List<Order> orders = new ArrayList<>();


    public List<Order> findAll() {
        return orders;
    }

    public Order insert(Order order) {
        order.setId(this.orders.size() + 1);
        this.orders.add(order);
        return order;
    }

    public Optional<Order> findById(Integer id) {
        return this.orders.stream()
                .filter(order -> order.getId().equals(id))
                .findFirst();
    }

    public Optional<Order> update(Integer id, Order order) {
        Optional<Order> existingOrder = this.findById(id);
        if (existingOrder.isEmpty()) {
            return existingOrder;
        }
        int index = this.orders.indexOf(existingOrder.get());
        order.setId(id);
        this.orders.set(index, order);
        return Optional.of(order);
    }

    public void deleteById(Integer id) {
        this.orders.removeIf(order -> order.getId().equals(id));
    }
}
