package br.com.ifsp.springboot2.repository;

import br.com.ifsp.springboot2.domain.Anime;
import br.com.ifsp.springboot2.domain.IfspUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

// vai ser a conexão com o banco de dados
public interface IfspUserRepository extends JpaRepository<IfspUser, Long> { // id é do tipo Long

    IfspUser findByUsername(String username);
}
