package ee.sda.finalprojectonlinestore.services;


import ee.sda.finalprojectonlinestore.entities.User;
import ee.sda.finalprojectonlinestore.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserService {

    final UserRepository repository;

    public User findByUsername(String username) {
        return repository.findByUsername(username);
    }
}