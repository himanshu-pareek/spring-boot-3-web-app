package dev.javarush.hackathon.ordermanagement.order;

public class OrderNotFoundException extends RuntimeException{
    public OrderNotFoundException(Integer id) {
        super("Order with id  = " + id + " not found.");
    }
}
