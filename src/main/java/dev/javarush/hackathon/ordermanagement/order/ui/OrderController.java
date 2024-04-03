package dev.javarush.hackathon.ordermanagement.order.ui;

import dev.javarush.hackathon.ordermanagement.order.Order;
import dev.javarush.hackathon.ordermanagement.order.OrderNotFoundException;
import dev.javarush.hackathon.ordermanagement.order.OrderService;
import dev.javarush.hackathon.ordermanagement.order.OrderStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

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

    @GetMapping("edit")
    public String newOrderPage(Model model, @RequestParam Map<String, String> params) {
        Order order = null;
        if (params.containsKey("id")) {
            Integer id = Integer.valueOf(params.get("id"));
            try {
                order = this.orderService.getOneOrder(id);
            } catch (RuntimeException e) {
                System.out.println("Order with id = " + id + " not found.");
            }
        }
        if (order == null) {
            order = new Order();
            order.setPlacedTime(LocalDateTime.now());
            order.setStatus(OrderStatus.CREATED);
        }
        model.addAttribute("order", order);
        return "edit-order";
    }

    @PutMapping
    public String createOrUpdate(@ModelAttribute("order") Order order) {
        if (order.getId() == null) {
            this.orderService.createNewOrder(order);
        } else {
            this.orderService.updateOrder(order.getId(), order);
        }
        return "redirect:/orders";
    }

    @DeleteMapping("{id}")
    public String delete(@PathVariable("id") Integer id) {
        this.orderService.deleteOrder(id);
        return "redirect:/orders";
    }
}
