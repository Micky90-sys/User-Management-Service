package com.nerlin.usermanagementservice.service;

import com.nerlin.usermanagementservice.model.User;
import com.nerlin.usermanagementservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username)
            .orElseThrow(() -> new UsernameNotFoundException("User not found"));
        return user;  
    }

    public User registerUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    // Aggiungi il metodo loginUser
    public UserDetails loginUser(User user) {
        UserDetails userDetails = loadUserByUsername(user.getUsername());
        if (passwordEncoder.matches(user.getPassword(), userDetails.getPassword())) {
            return userDetails;
        } else {
            throw new UsernameNotFoundException("Password incorrect");
        }
    }
}
