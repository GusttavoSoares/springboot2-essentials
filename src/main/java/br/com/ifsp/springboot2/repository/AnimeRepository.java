package br.com.ifsp.springboot2.repository;

import br.com.ifsp.springboot2.domain.Anime;

import java.util.List;

public interface AnimeRepository { // vai ser a conexão com o banco de dados
    List<Anime> listAll();
}
