package com.ajulieazvdo.playlist.music.application.api;

import com.ajulieazvdo.playlist.music.domain.Music;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class MusicDetalhadaResponse {
    private String idMusic;
    private String nome;
    private String artistaNome;
    private String album;

    public MusicDetalhadaResponse(Music music) {
        this.idMusic = music.getIdMusic();
        this.nome = music.getNome();
        this.artistaNome = music.getArtistaNome();
        this.album = music.getAlbum();
    }
}
