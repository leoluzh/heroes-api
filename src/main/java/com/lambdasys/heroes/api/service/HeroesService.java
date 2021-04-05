package com.lambdasys.heroes.api.service;

import com.lambdasys.heroes.api.document.Heroes;
import com.lambdasys.heroes.api.repository.HeroesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class HeroesService {

   private final HeroesRepository repository;

   public HeroesService(@Autowired final HeroesRepository repository){
       this.repository = repository;
   }

   public Flux<Heroes> findAll(){
       return Flux.fromIterable(this.repository.findAll());
   }

   public Mono<Heroes> findById(final String id){
       return Mono.justOrEmpty(this.repository.findById(id));
   }

   public Mono<Heroes> save(final Heroes heroes){
       return Mono.justOrEmpty(this.repository.save(heroes));
   }

   public Mono<Boolean> deleteById(final String id){
        this.repository.deleteById(id);
        return Mono.just(true);
   }

   public Mono<Boolean> delete(final Heroes heroes){
       this.repository.delete(heroes);
       return Mono.just(true);
   }

}
