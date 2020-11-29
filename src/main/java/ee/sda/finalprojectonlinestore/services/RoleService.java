package ee.sda.finalprojectonlinestore.services;

import ee.sda.finalprojectonlinestore.entities.Role;
import ee.sda.finalprojectonlinestore.repositories.RoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class RoleService {
    final RoleRepository roleRepository;

    public Role save(Role role) {
        return  roleRepository.save(role);
    }
}
