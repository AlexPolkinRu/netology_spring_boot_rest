package ru.netology.netology_spring_boot_rest.repository;

import org.springframework.stereotype.Repository;
import ru.netology.netology_spring_boot_rest.model.User;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author Aleksandr Polochkin
 * 16.10.2022
 */

@Repository
public class UserRepository {

    private final Map<String, User> users = new ConcurrentHashMap<>();

    public UserRepository() {

        users.put("admin",
                new User(
                        "admin",
                        "adminpass",
                        List.of(
                                Authorities.READ,
                                Authorities.WRITE,
                                Authorities.DELETE
                        )
                )
        );

        users.put("writer",
                new User(
                        "writer",
                        "writerpass",
                        List.of(
                                Authorities.READ,
                                Authorities.WRITE
                        )
                )
        );

        users.put("guest",
                new User(
                        "guest",
                        "guestpass",
                        List.of(
                                Authorities.READ
                        )
                )
        );
    }

    public List<Authorities> getUserAuthorities(String user, String password) {
        if (user.isEmpty() || password.isEmpty() || !users.containsKey(user)) {
            return Collections.emptyList();
        } else {
            User currentUser;
            if ((currentUser = users.get(user)).getPassword().equals(password)) {
                return currentUser.getAuthoritiesOfUser();
            } else {
                return null;
            }
        }
    }
}