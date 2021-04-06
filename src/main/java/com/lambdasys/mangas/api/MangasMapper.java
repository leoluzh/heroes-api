package com.lambdasys.mangas.api;

import com.lambdasys.mangas.api.document.Mangas;
import com.lambdasys.mangas.api.dto.MangasDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface MangasMapper {

    MangasMapper INSTANCE = Mappers.getMapper(MangasMapper.class);

    Mangas toModel(MangasDTO mangasDTO);
    MangasDTO toDTO(Mangas mangas);

}



