package dev.javarush.hackathon.ordermanagement.order.ui;

import dev.javarush.hackathon.ordermanagement.order.Order;
import dev.javarush.hackathon.ordermanagement.order.OrderNotFoundException;
import dev.javarush.hackathon.ordermanagement.order.OrderService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("orders")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping
    public String getAll(
            Model model
    ) {
        List<Order> orders = this.orderService.getAllOrders();
        model.addAttribute("orders", orders);
        return "orders";
    }

    @GetMapping("{id}")
    public String getOne(
            Model model,
            @PathVariable("id") Integer orderId
    ) {
        try {
            Order order = this.orderService.getOneOrder(orderId);
            model.addAttribute("order", order);
        } catch (OrderNotFoundException e) {
            model.addAttribute("error", e.getLocalizedMessage());
        }
        return "order";
    }

}
