package ee.sda.finalprojectonlinestore.services;

import ee.sda.finalprojectonlinestore.configurations.OnlineStoreUserDetails;
import ee.sda.finalprojectonlinestore.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class OnlineStoreUserDetailsService implements UserDetailsService {

    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException, DataAccessException {
        return new OnlineStoreUserDetails(userRepository.findByUsername(s));
    }
}
