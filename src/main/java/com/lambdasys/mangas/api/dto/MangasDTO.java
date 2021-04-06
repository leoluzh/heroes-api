package com.lambdasys.mangas.api.dto;

import com.lambdasys.mangas.api.document.AgeGroup;
import com.lambdasys.mangas.api.document.Format;
import com.lambdasys.mangas.api.document.Genre;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MangasDTO implements Serializable  {

    private String id;

    @NotBlank
    @Size(min=1,max=255)
    private String name;

    @NotBlank
    @Size(min=10,max=1000)
    private String description;

    @NotBlank
    @Size(min=1,max=255)
    private String publisher;

    @NotNull
    @Min(value =1900)
    private Integer year;

    @NotNull
    @Min(value =1)
    private Integer volumes;

    @NotNull
    private Genre genre;

    @NotNull
    private AgeGroup ageGroup;

    @NotNull
    private Format format;

}
