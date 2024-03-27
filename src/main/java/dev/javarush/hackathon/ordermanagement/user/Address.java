package dev.javarush.hackathon.ordermanagement.user;

public record Address(
        String street,
        String suite,
        String city,
        String zipcode,
        Geolocation geo
) {
}
