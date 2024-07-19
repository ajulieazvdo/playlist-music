package com.ajulieazvdo.playlist.playlist.application.api;

import com.ajulieazvdo.playlist.music.application.api.MusicListResponse;
import com.ajulieazvdo.playlist.playlist.domain.Playlist;
import lombok.Getter;

import java.util.List;
import java.util.stream.Collectors;

@Getter
public class PlaylistListResponse {
    private String nome;
    private List<MusicListResponse> musicListResponses;

    public PlaylistListResponse(Playlist playlist, List<MusicListResponse> musicListResponses) {
        this.nome = playlist.getNome();
        this.musicListResponses = musicListResponses;
    }

    public static List<MusicListResponse> converterPlaylist(Playlist playlist) {
        return playlist.getMusics().stream()
                .map(MusicListResponse::new)
                .collect(Collectors.toList());
    }
}
