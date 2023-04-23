package com.commerceplatform.api.stock.security;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CustomUserDetailsService implements UserDetailsService {
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
//        var userModel = userRepository.findByEmail(email)
//                .orElseThrow(() -> new NotFoundException("No user found with email " + email));

//        return new User(
//                userModel.getEmail(),
//                userModel.getPassword(),
//                true,
//                true,
//                true,
//                true,
//                userModel.getAuthorities());
        return null;
    }
}