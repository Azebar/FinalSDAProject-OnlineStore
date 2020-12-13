package ee.sda.finalprojectonlinestore.services;


import ee.sda.finalprojectonlinestore.entities.User;
import ee.sda.finalprojectonlinestore.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.security.Principal;
import java.util.Date;

@RequiredArgsConstructor
@Service
public class UserService {

    @Autowired
    PasswordEncoder passwordEncoder;

    final UserRepository repository;

    public User save(User user) {
        User emptyUser = new User();
        emptyUser.setCreated(new Date());
        User oldUser = repository.findById(user.getId()).orElse(emptyUser);
        user.setCreated(oldUser.getCreated());
        repository.save(user);
        return user;
    }

    public User getCurrentUser() {
        Principal principal = SecurityContextHolder.getContext().getAuthentication();
        return repository.findByUsername(principal.getName());
    }

}