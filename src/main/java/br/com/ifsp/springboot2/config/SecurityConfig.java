package br.com.ifsp.springboot2.config;

import lombok.extern.log4j.Log4j2;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
@Log4j2
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .anyRequest()
                .authenticated()
                .and().httpBasic();
        // todas urls do controller vão precisar passar por autenticação básica
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        // criando um usuário em memoria e definindo um tipo de criptografia para a senha
        PasswordEncoder passwordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
        log.info("Password encoded {}", passwordEncoder.encode("test"));
        auth.inMemoryAuthentication()
                .withUser("gustavo")
                .password(passwordEncoder.encode("ifsp"))
                .roles("USER", "ADMIN")
                .and()
                .withUser("soares")
                .password(passwordEncoder.encode("ifsp"))
                .roles("USER"); // é apenas um usuário

    }
}
