package br.com.ifsp.springboot2.repository;

import br.com.ifsp.springboot2.domain.Anime;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
// vai ser a conexão com o banco de dados
public interface AnimeRepository extends JpaRepository<Anime, Long> { // id é do tipo Long

}
