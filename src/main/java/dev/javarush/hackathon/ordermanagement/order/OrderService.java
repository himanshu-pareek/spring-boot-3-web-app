package dev.javarush.hackathon.ordermanagement.order;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.function.Supplier;

@Service
public class OrderService {

    private final DBOrderRepository orderRepository;

    public OrderService(DBOrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public List<Order> getAllOrders() {
        return this.orderRepository.findAll();
    }

    public Order createNewOrder(Order order) {
        order.setName(order.getName().trim());
        if (order.getName().length() < 5 || order.getName().length() > 20) {
            throw new IllegalArgumentException("Order's name must be of length 5 to 20.");
        }
        return this.orderRepository.insert(order);
    }

    public Order getOneOrder(Integer id) {
        return this.orderRepository.findById(id).orElseThrow(() -> new OrderNotFoundException(id));
    }

    public Order updateOrder(Integer id, Order order) {
        return this.orderRepository.update (id, order).orElseThrow(() -> new OrderNotFoundException(id));
    }

    public void deleteOrder(Integer id) {
        this.orderRepository.findById(id).orElseThrow(() -> new OrderNotFoundException(id));
        this.orderRepository.deleteById (id);
    }
}
