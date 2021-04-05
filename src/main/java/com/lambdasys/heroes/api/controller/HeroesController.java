package com.lambdasys.heroes.api.controller;

import com.lambdasys.heroes.api.constants.HeroesConstants;
import com.lambdasys.heroes.api.document.Heroes;
import com.lambdasys.heroes.api.service.HeroesService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Slf4j
@RestController
@RequestMapping(value = HeroesConstants.HEROES_ENDPOINT)
public class HeroesController {

    private HeroesService service;

    public HeroesController(@Autowired final HeroesService service){
        this.service = service;
    }

    @GetMapping
    public Flux<Heroes> findAll(){
        log.info("request a list off all heroes");
        return this.service.findAll();
    }

    @GetMapping("/{id}")
    public Mono<ResponseEntity<Heroes>> findById(@PathVariable String id){
        log.info("request a hero with id: {}",id);
        return this.service.findById(id)
                .map(ResponseEntity::ok)
                .defaultIfEmpty(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<Heroes> save(@RequestBody Heroes heroes){
        log.info("post a hero with content {}",heroes);
        return this.service.save(heroes);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Mono<HttpStatus> deleteById(@PathVariable final String id){
        log.info("delete a hero with id {}",id);
        this.service.deleteById(id);
        return Mono.just(HttpStatus.NO_CONTENT);
    }

}
