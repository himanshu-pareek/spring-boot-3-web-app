package dev.javarush.hackathon.ordermanagement.user;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.service.annotation.GetExchange;

public interface UserHTTPClient {

    @GetExchange("/{id}")
    User findById(@PathVariable("id") Integer id);

}
