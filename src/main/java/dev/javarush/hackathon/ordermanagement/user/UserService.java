package dev.javarush.hackathon.ordermanagement.user;

import org.springframework.context.annotation.Bean;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.client.JdkClientHttpRequestFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.support.RestClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

@Service
public class UserService {

    private final RestClient restClient;
    private final UserHTTPClient userHTTPClient;

    public UserService(RestClient.Builder builder) {
        restClient = builder.baseUrl("https://jsonplaceholder.typicode.com/users")
                .build();
        HttpServiceProxyFactory factory = HttpServiceProxyFactory.builderFor(
                RestClientAdapter.create(this.restClient)
        ).build();
        this.userHTTPClient = factory.createClient(UserHTTPClient.class);
    }

    public User getUserById (Integer id) {
//        return this.restClient.get()
//                .uri("/{id}", id)
//                .retrieve()
//                .body(User.class);
        return this.userHTTPClient.findById(id);
    }

    public Iterable<User> getAllUsers () {
        return restClient.get()
                .retrieve()
                .body(new ParameterizedTypeReference<>() {});
    }

}
