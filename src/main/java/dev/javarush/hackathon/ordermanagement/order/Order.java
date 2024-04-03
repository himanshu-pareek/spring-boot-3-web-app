package dev.javarush.hackathon.ordermanagement.order;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

public class Order {
    private Integer id;

    @NotNull
    @NotBlank
    @Length(
            min = 5,
            max = 20
    )
    private String name;
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'hh:mm")
    private LocalDateTime placedTime;
    private Integer totalAmount;
    private OrderStatus status;

    public Order() {}

    public Order(Integer id, String name, LocalDateTime placedTime, Integer totalAmount, OrderStatus status) {
        this.id = id;
        this.name = name;
        this.placedTime = placedTime;
        this.totalAmount = totalAmount;
        this.status = status;
    }

    public Order(String name, LocalDateTime placedTime, Integer totalAmount, OrderStatus status) {
        this.name = name;
        this.placedTime = placedTime;
        this.totalAmount = totalAmount;
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDateTime getPlacedTime() {
        return placedTime;
    }

    public void setPlacedTime(LocalDateTime placedTime) {
        this.placedTime = placedTime;
    }

    public Integer getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Integer totalAmount) {
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
