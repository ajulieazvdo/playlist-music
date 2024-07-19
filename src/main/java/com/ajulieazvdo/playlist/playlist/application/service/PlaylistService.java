package com.ajulieazvdo.playlist.playlist.application.service;

import com.ajulieazvdo.playlist.playlist.application.api.PlaylistAlteraRequest;
import com.ajulieazvdo.playlist.playlist.application.api.PlaylistListResponse;
import com.ajulieazvdo.playlist.playlist.application.api.PlaylistRequest;
import com.ajulieazvdo.playlist.playlist.application.api.PlaylistResponse;

public interface PlaylistService {
    PlaylistResponse salvarPlaylist(PlaylistRequest playlistRequest);
    PlaylistListResponse buscarPlaylistPorId(String idPlaylist);
    void associaMusicaAPlaylist(String idPlaylist, String idMusica);
    void desassociaMusicaAPlaylist(String idPlaylist, String idMusica);
    void deletarPlaylist(String idPlaylist);
    void alterarPlaylist(String idPlaylist, PlaylistAlteraRequest playlistRequest);
}
