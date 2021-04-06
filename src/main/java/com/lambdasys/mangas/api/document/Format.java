package com.lambdasys.mangas.api.document;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import lombok.Getter;

public enum Format {

    SHINSOBAN("É uma nova edição liberada com (geralmente) uma nova capa. Os volumes geralmente têm páginas coloridas novas e outros extras.") ,
    BUNKOBAN("Edição Econômica, bem pequenos, formato de bolso com mais páginas e mais baratos"),
    AIZOBAN("Edição de Colecionador. Costuma ter um acabamento e papel melhor e às vezes capa dura."),
    WIDEBAN("O wide-ban ou waidoban (ワイド版?) é num formato maior (A5) do que um tankōbon regular. Muitos mangás, particularmente em mangás seinen e josei, são publicados em edições wide-ban após a publicação em revistas, e nunca são lançados no formato tankōbon que é comum em shōnen e shōjo."),
    KANZENBAN("O kanzenban (完全版?) é uma Edição de Luxo, no Brasil a Conrad Editora lançou alguns volumes da série Dragon Ball[7]. Tem papel de altíssima qualidade, com acabamento primoroso, posters, material inédito, retoque de arte."),
    KYUKYOKUBAN("O Kyūkyokuban (究極版?) é uma Edição de Luxo. Essa costuma surgir anos após o edição kanzenban de uma obra e compartilha das mesmas características, tendo como diferença o tamanho que é menor mais parecido com o do Tankōbon."),
    KAITEIBAN("O Kaitei-ban (改訂版?) Edição Revisada, onde a obra é reeditada pelo autor contando com páginas redesenhadas, novos capítulos adicionados e páginas coloridas."),
    SOSHUEN("O Sōshūhen (総集編?) é um formato relativamente novo publicado pela Shueisha a partir de 2008. Uma edição sōshūhen é do tamanho B5 (176 × 250 mm), maior que um kanzenban e reproduz similarmente capas de capítulos e páginas coloridas, enquanto incluindo também uma variedade de recursos de bônus, como pôsteres e entrevistas."),
    FULLCOLOR("Full Color (フルカラー?) é uma Edição de Luxo, estilo graphic novel que mostra uma versão 100% colorida de um mangá.");

    Format(String description){
        this.description = description;
    }

    @Getter
    private String description;

}
