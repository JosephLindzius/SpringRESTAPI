package com.blauwmaan.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.security.core.userdetails.User;

@Component
public class DetailsService implements UserDetailsService {
    @Autowired
    UserRepository users;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        com.blauwmaan.user.User usered = users.findByUsername(username);
        if (usered == null){
            throw new UsernameNotFoundException(username + " was not found");
        }

        return new User(
                usered.getUsername(),
                usered.getPassword(),
                AuthorityUtils.createAuthorityList(usered.getRoles())
        );
    }
}
