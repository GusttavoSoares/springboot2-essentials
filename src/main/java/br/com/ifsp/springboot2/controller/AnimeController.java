package br.com.ifsp.springboot2.controller;

import br.com.ifsp.springboot2.domain.Anime;
import br.com.ifsp.springboot2.util.DateUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;

@RestController // retorno dessa classe é apenas string
@RequestMapping("anime")
@Log4j2
@RequiredArgsConstructor

public class AnimeController {
    private final DateUtil dateUtil;


    @GetMapping(path = "list")
    public List<Anime> list() {
        log.info(dateUtil.formatLocalDateTimeToDatabaseStyle(LocalDateTime.now()));
        return List.of(new Anime("Boku No Hero"), new Anime("Mirai Nikki"));
    }
}