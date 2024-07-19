package com.ajulieazvdo.playlist.playlist.application.api;

import com.ajulieazvdo.playlist.playlist.domain.Playlist;
import lombok.Getter;

@Getter
public class PlaylistResponse {
    private String idPlaylist;

    public PlaylistResponse(Playlist playlist) {
        this.idPlaylist = playlist.getIdPlaylist();
    }
}
