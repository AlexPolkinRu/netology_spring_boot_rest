package ru.netology.netology_spring_boot_rest.model;

import ru.netology.netology_spring_boot_rest.repository.Authorities;

import java.util.List;

/**
 * @author Aleksandr Polochkin
 * 01.11.2022
 */

public class User {
    private final String name;
    private final String password;
    private final List<Authorities> authoritiesOfUser;

    public User(String name, String password, List<Authorities> authoritiesOfUser) {
        this.name = name;
        this.password = password;
        this.authoritiesOfUser = authoritiesOfUser;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public List<Authorities> getAuthoritiesOfUser() {
        return authoritiesOfUser;
    }
}
