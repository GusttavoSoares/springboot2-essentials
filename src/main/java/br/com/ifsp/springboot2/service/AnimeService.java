package br.com.ifsp.springboot2.service;

import br.com.ifsp.springboot2.domain.Anime;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnimeService { // classe responsável pelas regras de negócio
    // private final AnimeRepository animeRepository;
    public List<Anime> listAll() {
        return List.of(new Anime(1L, "Boku No Hero"), new Anime(2L, "Mirai Nikki"));
    }
}
