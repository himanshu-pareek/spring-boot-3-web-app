package dev.javarush.hackathon.ordermanagement.user;

public record User(
        Integer id,
        String name,
        String username,
        String email,
        Address address,
        String phone,
        String website,
        Company company
) {
}
