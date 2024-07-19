package com.ajulieazvdo.playlist.music.application.api;

import com.ajulieazvdo.playlist.music.domain.Music;
import com.ajulieazvdo.playlist.playlist.domain.Playlist;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@NoArgsConstructor
public class MusicListResponse {
    private String idMusic;
    private String nome;
    private String artistaNome;
    private String album;

    public MusicListResponse(Music music) {
        this.idMusic = music.getIdMusic();
        this.nome = music.getNome();
        this.artistaNome = music.getArtistaNome();
        this.album = music.getAlbum();
    }

    public static List<MusicListResponse> converter(List<Music> musicas) {
        return musicas.stream()
                .map(MusicListResponse::new)
                .collect(Collectors.toList());
    }
}
