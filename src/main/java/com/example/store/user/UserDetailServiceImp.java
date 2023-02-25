package com.example.store.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.store.user.User;
import com.example.store.user.UserRepository;

/**
 * This class is used by spring security to authenticate and authorize user
 **/
@Service
public class UserDetailServiceImp implements UserDetailsService  {
    private final UserRepository repository;

    @Autowired
    public UserDetailServiceImp(UserRepository userRepository) {
        this.repository = userRepository;
    }

   @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException
    {
        User curruser = repository.findByUsername(username);
        return new org.springframework.security.core.userdetails.User(username, curruser.getPassword(),
                AuthorityUtils.createAuthorityList(curruser.getRole()));
        //return user;
    }
}
