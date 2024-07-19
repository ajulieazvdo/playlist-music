package com.ajulieazvdo.playlist.playlist.application.repositpory;

import com.ajulieazvdo.playlist.playlist.domain.Playlist;

public interface PlaylistRepository {
    Playlist salvarPlaylist(Playlist playlist);

    Playlist buscarUmaPlaylistPorId(String idPlaylist);

    void deletarPlaylist(Playlist playlist);
}
