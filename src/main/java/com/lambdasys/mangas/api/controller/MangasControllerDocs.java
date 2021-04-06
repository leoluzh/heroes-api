package com.lambdasys.mangas.api.controller;

import com.lambdasys.mangas.api.document.Mangas;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface MangasControllerDocs {

    @Operation(description = "Return a list of all mangas registered in the system.")
    @ApiResponses(value={
            @ApiResponse(responseCode = "200" , description = "List of all mangas registered in the system."),
    })
    Flux<Mangas> findAll();

    @Operation(description = "Returns manga found by a given id")
    @ApiResponses(value={
            @ApiResponse(responseCode = "200", description = "Success manga found in the system.",
                    content = {@Content(mediaType = "application/json" , schema = @Schema(implementation = Mangas.class))}),
            @ApiResponse(responseCode = "404", description = "Manga with given name not found.", content = @Content)
    })
    Mono<ResponseEntity<Mangas>> findById(@PathVariable String id);

    @Operation(description = "Manga creating operation")
    @ApiResponses(value={
            @ApiResponse(responseCode = "201", description = "Success manga creation.",
                    content = {@Content(mediaType = "application/json" , schema = @Schema(implementation = Mangas.class))}),
            @ApiResponse(responseCode = "400", description = "Missing required fields or wrong field range value.", content = @Content)
    })
    Mono<Mangas> save(@RequestBody Mangas mangas);

    @Operation(description="Delete an manga found by a given valid id")
    @ApiResponses(value={
            @ApiResponse(responseCode = "204", description = "Success manga deleted in the system." , content = @Content(mediaType = "application/json")) ,
            @ApiResponse(responseCode = "404", description = "Manga with given id not found.", content = @Content)
    })
    Mono<HttpStatus> deleteById(@PathVariable final String id);

}
