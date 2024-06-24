package com.evaluation.system.authorization.user.infrastructure.adapters.output.jpaAdapter;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.evaluation.system.authorization.user.infrastructure.adapters.output.jpaAdapter.Entity.user.UserEntity;
import com.evaluation.system.authorization.user.infrastructure.adapters.output.jpaAdapter.repository.IUserRepository;


@Service
public class UserDetailsServiceImpl implements UserDetailsService{

    @Autowired
    private  IUserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<UserEntity>  userOptinal = userRepository.findByUsername(username);
        UserEntity user = userOptinal.orElse(null);    
        if(user==null) throw new UsernameNotFoundException("User not found");
        return user;
    }

     
}