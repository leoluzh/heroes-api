package com.lambdasys.mangas.api.controller;

import com.lambdasys.mangas.api.constants.MangasConstants;
import com.lambdasys.mangas.api.document.Mangas;
import com.lambdasys.mangas.api.repository.MangasRepository;
import com.lambdasys.mangas.api.service.MangasService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Slf4j
@RestController
@RequestMapping(value = MangasConstants.MANGAS_ENDPOINT)
public class MangasController {

    private final MangasService service;
    private final MangasRepository repository;

    public MangasController(final MangasService service, final MangasRepository repository){
        this.service = service;
        this.repository = repository;
    }

    @GetMapping
    public Flux<Mangas> findAll(){
        log.info("request a list off all mangas");
        return this.service.findAll();
    }

    @GetMapping("/{id}")
    public Mono<ResponseEntity<Mangas>> findById(@PathVariable String id){
        log.info("request a manga with id: {}",id);
        return this.service.findById(id)
                .map(ResponseEntity::ok)
                .defaultIfEmpty(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<Mangas> save(@RequestBody Mangas mangas){
        log.info("post a manga with content {}", mangas);
        return this.service.save(mangas);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Mono<HttpStatus> deleteById(@PathVariable final String id){
        log.info("delete a manga with id {}",id);
        this.service.deleteById(id);
        return Mono.just(HttpStatus.NO_CONTENT);
    }

}
