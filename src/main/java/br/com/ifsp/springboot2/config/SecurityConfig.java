package br.com.ifsp.springboot2.config;

import br.com.ifsp.springboot2.service.IfspUserDetailsService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;

@EnableWebSecurity
@Log4j2
@EnableGlobalMethodSecurity(prePostEnabled = true)
@RequiredArgsConstructor
@SuppressWarnings("java:S5344")
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    private final IfspUserDetailsService ifspUserDetailsService;

    /**
     * BasicAuthenticationFilter
     * UsernamePasswordAuthenticationFilter
     * DefaultLoginPageGenerationFilter
     * DefaultLogoutPageGenerationFilter
     * FilterSecurityInterceptor
     * Authentication -> Authorization
     * @param http
     * @throws Exception
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
//                .csrf().csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse())
                .authorizeRequests()
                .antMatchers("/animes/admin/**").hasRole("ADMIN") // ordem dos dois importa!
                .antMatchers("/animes/**").hasRole("USER")
                .anyRequest()
                .authenticated()
                .and()
                .formLogin()
                .and()
                .httpBasic();
        // todas urls do controller vão precisar passar por autenticação básica
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        // criando um usuário em memoria e definindo um tipo de criptografia para a senha
        PasswordEncoder passwordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
        log.info("Password encoded {}", passwordEncoder.encode("academy"));
        auth.inMemoryAuthentication()
                .withUser("gustavo2")
                .password(passwordEncoder.encode("ifsp"))
                .roles("USER", "ADMIN")
                .and()
                .withUser("soares2")
                .password(passwordEncoder.encode("ifsp"))
                .roles("USER"); // é apenas um usuário
        auth.userDetailsService(ifspUserDetailsService)
                .passwordEncoder(passwordEncoder);
    }
}
