package com.ajulieazvdo.playlist.music.domain;

import com.ajulieazvdo.playlist.music.application.api.MusicAlteraRequest;
import com.ajulieazvdo.playlist.music.application.api.MusicRequest;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@ToString
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@Builder
public class Music {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String idMusic;
    @Column(nullable = false)
    private String nome;
    @Column(nullable = false)
    private String artistaNome;
    private String album;

    public Music(MusicRequest musicRequest) {
        this.nome = musicRequest.getNome();
        this.artistaNome = musicRequest.getArtistaNome();
        this.album = musicRequest.getAlbum();
    }

    public void alterar(MusicAlteraRequest musicRequest) {
        this.nome = musicRequest.getNome();
        this.artistaNome = musicRequest.getArtistaNome();
        this.album = musicRequest.getAlbum();
    }
}
