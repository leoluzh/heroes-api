package com.lambdasys.heroes.api.service;

import com.lambdasys.heroes.api.repository.HeroesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HeroesService {

   private final HeroesRepository repository;

   public HeroesService(@Autowired final HeroesRepository repository){
       this.repository = repository;
   }

}
