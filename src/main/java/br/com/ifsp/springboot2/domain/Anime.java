package br.com.ifsp.springboot2.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data // gera get, set, equals, hashcode
@AllArgsConstructor // gera construtores com todos os valores
public class Anime { // Essa classe representa o que tem no banco de dados
    private Long id;
    private String name;

}
