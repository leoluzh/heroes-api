package com.lambdasys.mangas.api.document;

import lombok.Getter;

public enum Genre {

    NEKKETSU("tipo de mangá em que as cenas de ação, onde os personagens defendem os valores da amizade e do treinamento. Exemplos: Dragon Ball, Hokuto no Ken, One Piece, Bleach, Naruto, Saint Seiya."),
    SPOKON("mangá esportivo. O termo vem de contração da palavra inglesa 'sport' com a japonesa 'konjō' que significa 'coragem. Exemplos: Inazuma Eleven, Eyeshield 21, Captain Tsubasa"),
    GEKIGA("mangás adulto e temas dramáticos Exemplos: Lobo Solitário, Crying Freeman, A Lenda de Kamui."),
    MAGICAL_GIRL("meninas ou rapazes que têm algum objeto mágico ou poder especial. Exemplos: Sailor Moon, Sakura Card Captor, Mahou Shoujo Madoka Magica, Black Rock Shooter."),
    YURI("história de amor entre meninas. Exemplo: Kannazuki no Miko."),
    YAOI("história de amor entre homens. Exemplo: Sekai-ichi Hatsukoi."),
    HAREM("rapaz cercado de garotas. Exemplo: Love hina, Negima!."),
    MECHA("os robôs têm presença significativa em muitas ocasiões gigantes e tripulada por seres humanos. Exemplos Tengen Toppa Gurren Lagann, Gundam, Code Geass e Escaflowne."),
    HENTAI("mangás pornográficos, a maioria, heterossexual."),
    ANIPARO("paródias de animes, mangás entre outros, muito comum em dōjinshis."),
    JIDAIMONO("Mangá histórico. Exemplo: Lobo Solitário"),
    JOHO("Mangá educativo.");

    Genre(String description){
        this.description = description;
    }

    @Getter
    private String description;

}
