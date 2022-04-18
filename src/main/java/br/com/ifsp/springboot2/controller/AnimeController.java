package br.com.ifsp.springboot2.controller;

import br.com.ifsp.springboot2.domain.Anime;
import br.com.ifsp.springboot2.service.AnimeService;
import br.com.ifsp.springboot2.util.DateUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.time.LocalDateTime;
import java.util.List;

@RestController // retorno dessa classe é apenas string
@RequestMapping("animes")
@Log4j2
@RequiredArgsConstructor // faz construtor com as variáveis que utilizam final

public class AnimeController {
    private final DateUtil dateUtil;
    private final AnimeService animeService;


    @GetMapping // home
    public ResponseEntity<List<Anime>> list() {
        log.info(dateUtil.formatLocalDateTimeToDatabaseStyle(LocalDateTime.now()));
        return  ResponseEntity.ok(animeService.listAll());
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Anime> findById(@PathVariable long id) {
        log.info(dateUtil.formatLocalDateTimeToDatabaseStyle(LocalDateTime.now()));
        return  ResponseEntity.ok(animeService.findById(id));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Anime> save(@RequestBody Anime anime){
        animeService.save(anime);
        return new ResponseEntity<>(animeService.save(anime), HttpStatus.CREATED);
    }
}