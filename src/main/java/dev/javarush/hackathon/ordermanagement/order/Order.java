package dev.javarush.hackathon.ordermanagement.order;

import java.time.LocalDateTime;

public class Order {
    private Integer id;
    private String name;
    private LocalDateTime placedTime;
    private Integer totalAmount;
    private OrderStatus status;

    public Order(Integer id, String name, LocalDateTime placedTime, Integer totalAmount, OrderStatus status) {
        this.id = id;
        this.name = name;
        this.placedTime = placedTime;
        this.totalAmount = totalAmount;
        this.status = status;
    }

    Order(String name, LocalDateTime placedTime, Integer totalAmount, OrderStatus status) {
        this.name = name;
        this.placedTime = placedTime;
        this.totalAmount = totalAmount;
        this.status = status;
    }

    Integer getId() {
        return id;
    }

    void setId(Integer id) {
        this.id = id;
    }

    String getName() {
        return name;
    }

    void setName(String name) {
        this.name = name;
    }

    LocalDateTime getPlacedTime() {
        return placedTime;
    }

    void setPlacedTime(LocalDateTime placedTime) {
        this.placedTime = placedTime;
    }

    Integer getTotalAmount() {
        return totalAmount;
    }

    void setTotalAmount(Integer totalAmount) {
        this.totalAmount = totalAmount;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", placedTime=" + placedTime +
                ", totalAmount=" + totalAmount +
                ", status=" + status +
                '}';
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }
}
