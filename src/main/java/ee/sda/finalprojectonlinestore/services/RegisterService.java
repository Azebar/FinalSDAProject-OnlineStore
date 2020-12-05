package ee.sda.finalprojectonlinestore.services;

import ee.sda.finalprojectonlinestore.entities.Role;
import ee.sda.finalprojectonlinestore.entities.User;
import ee.sda.finalprojectonlinestore.repositories.RoleRepository;
import ee.sda.finalprojectonlinestore.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class RegisterService {

    @Autowired
    BCryptPasswordEncoder encoder;

    @Autowired
    UserRepository userRepository;
    @Autowired
    RoleRepository roleRepository;

    public User createUser(User user) {
        user.setCreated(new Date());
        user.setPassword(encoder.encode(user.getPassword()));
        List<Role> roles = roleRepository.findByName("ROLE_USER");
        user.setRoles(roles);
        List<User> users = roles.get(0).getUsers();
        users.add(user);
        user = userRepository.save(user);
        roles.get(0).setUsers(users);
        roleRepository.save(roles.get(0));

        return user;
    }
}

