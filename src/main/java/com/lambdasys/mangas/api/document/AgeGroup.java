package com.lambdasys.mangas.api.document;

import lombok.Getter;

public enum AgeGroup {

    KODOMO("destinado a crianças de tenra idade."),
    SHONEN("destinado a garotos adolescentes."),
    SHOUJO("destinado a garotas adolescentes."),
    SEINEN("destinado a homens jovens e adultos."),
    JOSEI("destinado a mulheres jovens e adultas.");

    AgeGroup(String description){
        this.description = description;
    }

    @Getter
    private String description;

}
