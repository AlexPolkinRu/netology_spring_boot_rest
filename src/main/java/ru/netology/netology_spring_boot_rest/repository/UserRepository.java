package ru.netology.netology_spring_boot_rest.repository;

import org.springframework.stereotype.Repository;
import ru.netology.netology_spring_boot_rest.Authorities;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author Aleksandr Polochkin
 * 16.10.2022
 */

@Repository
public class UserRepository {

    private final ConcurrentHashMap<String, List<Authorities>> authoritiesOfUser;

    public UserRepository() {
        authoritiesOfUser = new ConcurrentHashMap<>();

        authoritiesOfUser.put("admin", List.of(
                Authorities.READ,
                Authorities.WRITE,
                Authorities.DELETE
        ));

        authoritiesOfUser.put("writer", List.of(
                Authorities.READ,
                Authorities.WRITE
        ));

        authoritiesOfUser.put("guest", List.of(
                Authorities.READ
        ));
    }

    public List<Authorities> getUserAuthorities(String user, String password) {
        if (!user.isEmpty() && !password.isEmpty()) {
            return authoritiesOfUser.getOrDefault(user, Collections.emptyList());
        }
        return Collections.emptyList();
    }
}