package com.ajulieazvdo.playlist.playlist.domain;

import com.ajulieazvdo.playlist.music.domain.Music;
import com.ajulieazvdo.playlist.playlist.application.api.PlaylistAlteraRequest;
import com.ajulieazvdo.playlist.playlist.application.api.PlaylistRequest;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@ToString
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@Builder
public class Playlist {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String idPlaylist;
    @Column(nullable = false)
    private String nome;
    private String descricao;

    @OneToMany
    private List<Music> musics = new ArrayList<>();

    public Playlist(PlaylistRequest playlistRequest) {
        this.nome = playlistRequest.getNome();
        this.descricao = playlistRequest.getDescricao();
    }

    public void alterar(PlaylistAlteraRequest playlistRequest) {
        this.nome = playlistRequest.getNome();
        this.descricao = playlistRequest.getDescricao();
    }
}
