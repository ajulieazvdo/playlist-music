package com.ajulieazvdo.playlist.playlist.application.api;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class PlaylistRequest {
    @NotBlank
    private String nome;
    private String descricao;
}
