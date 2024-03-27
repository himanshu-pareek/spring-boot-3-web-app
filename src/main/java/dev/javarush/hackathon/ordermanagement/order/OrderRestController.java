package dev.javarush.hackathon.ordermanagement.order;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/orders")
public class OrderRestController {

    private final OrderService orderService;

    public OrderRestController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping
    public List<Order> getAll() {
        return this.orderService.getAllOrders();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Order create(
            @RequestBody @Valid Order order
    ) {
        return this.orderService.createNewOrder(order);
    }

    @GetMapping("{id}")
    public Order getOne(
            @PathVariable("id") Integer id
    ) {
        return this.orderService.getOneOrder (id);
    }

    @PutMapping("{id}")
    public Order updateOrder(
            @PathVariable("id") Integer id,
            @RequestBody Order order
    ) {
        return this.orderService.updateOrder (id, order);
    }

    @DeleteMapping("{id}")
    public void deleteOrder(
            @PathVariable("id") Integer id
    ) {
        this.orderService.deleteOrder (id);
    }
}
