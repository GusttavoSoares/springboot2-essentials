package br.com.ifsp.springboot2.service;

import br.com.ifsp.springboot2.repository.IfspUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class IfspUserDetailsService implements UserDetailsService {
    private final IfspUserRepository ifspUserRepository;

    @Override
    public UserDetails loadUserByUsername(String username) {
        return Optional.ofNullable(ifspUserRepository.findByUsername(username))
                .orElseThrow(() -> new UsernameNotFoundException("Ifsp User not found"));
    }
}
