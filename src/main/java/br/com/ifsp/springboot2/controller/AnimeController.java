package br.com.ifsp.springboot2.controller;

import br.com.ifsp.springboot2.domain.Anime;
import br.com.ifsp.springboot2.requests.AnimePostRequestBody;
import br.com.ifsp.springboot2.requests.AnimePutRequestBody;
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
        return  ResponseEntity.ok(animeService.findByIdOrThrowBadRequestException(id));
    }

    @PostMapping
    public ResponseEntity<Anime> save(@RequestBody AnimePostRequestBody animePostRequestBody){
        return new ResponseEntity<>(animeService.save(animePostRequestBody), HttpStatus.CREATED);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable long id) {
        animeService.delete(id);
        return  new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping
    public ResponseEntity<Void> replace(@RequestBody AnimePutRequestBody animePutRequestBody) {
        animeService.replace(animePutRequestBody);
        return  new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}