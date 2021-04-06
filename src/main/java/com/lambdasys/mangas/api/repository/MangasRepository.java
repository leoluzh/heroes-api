package com.lambdasys.mangas.api.repository;

import com.lambdasys.mangas.api.document.Mangas;
import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;

@EnableScan
public interface MangasRepository extends CrudRepository<Mangas,String> {

}
