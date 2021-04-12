package com.lambdasys.mangas.api.service;

import com.lambdasys.mangas.api.MangasMapper;
import com.lambdasys.mangas.api.document.Mangas;
import com.lambdasys.mangas.api.repository.MangasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class MangasService {

   private final MangasRepository repository;
   private final MangasMapper mangasMapper = MangasMapper.INSTANCE;

   public MangasService(final MangasRepository repository){
       this.repository = repository;
   }

   public Flux<Mangas> findAll(){
       return Flux.fromIterable(this.repository.findAll());
   }

   public Mono<Mangas> findById(final String id){
       return Mono.justOrEmpty(this.repository.findById(id));
   }

   public Mono<Mangas> save(final Mangas mangas){
       return Mono.justOrEmpty(this.repository.save(mangas));
   }

   public Mono<Boolean> deleteById(final String id){
        this.repository.deleteById(id);
        return Mono.just(true);
   }

   public Mono<Boolean> delete(final Mangas mangas){
       this.repository.delete(mangas);
       return Mono.just(true);
   }

}
