package br.com.ifsp.springboot2.client;

import br.com.ifsp.springboot2.domain.Anime;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

@Log4j2
public class SpringClient {
    public static void main(String[] args) {
        ResponseEntity<Anime> entity = new RestTemplate().getForEntity("http://localhost:444/animes/{id}", Anime.class,9);
        log.info(entity);

        Anime object = new RestTemplate().getForObject("http://localhost:444/animes/{id}", Anime.class,9);

        log.info(object);
    }
}
