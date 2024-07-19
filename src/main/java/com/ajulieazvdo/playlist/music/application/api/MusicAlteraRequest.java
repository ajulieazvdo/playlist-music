package com.ajulieazvdo.playlist.music.application.api;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class MusicAlteraRequest {
    @NotBlank
    private String nome;
    @NotBlank
    private String artistaNome;
    private String album;
}
