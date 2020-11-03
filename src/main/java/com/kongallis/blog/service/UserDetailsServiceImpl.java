package com.kongallis.blog.service;

import com.kongallis.blog.models.User;
import com.kongallis.blog.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Collections;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // Throws an error if it does not find the user
        User user = userRepository.findByUserName(username).orElseThrow(()->
                new UsernameNotFoundException("No user found " + username));

        // The User class, but from another (UserDetails - Spring Security)
        return new org.springframework.security.core.userdetails.User(user.getUserName(),
                user.getPassword(),
                true,
                true,
                true,
                true,
                getAuthorities("ROLE_USER"));
    }

    // Passing the role
    private Collection<? extends GrantedAuthority> getAuthorities(String role_user) {
        return Collections.singletonList(new SimpleGrantedAuthority(role_user));
    }

}
