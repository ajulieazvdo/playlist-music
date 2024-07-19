package com.ajulieazvdo.playlist.playlist.application.api;

import com.ajulieazvdo.playlist.playlist.application.service.PlaylistService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Log4j2
public class PlaylistController implements PlaylistAPI {
    private final PlaylistService playlistService;
    @Override
    public PlaylistResponse criarPlaylist(PlaylistRequest playlistRequest) {
        log.info("[inicia] PlaylistController - criarPlaylist");
        PlaylistResponse playlist = playlistService.salvarPlaylist(playlistRequest);
        log.info("[finaliza] PlaylistController - criarPlaylist");
        return playlist;
    }

    @Override
    public PlaylistListResponse listarPlaylist(String idPlaylist) {
        log.info("[inicia] PlaylistController - listarPlaylist");
        PlaylistListResponse playlist = playlistService.buscarPlaylistPorId(idPlaylist);
        log.info("[finaliza] PlaylistController - listarPlaylist");
        return playlist;
    }

    @Override
    public void associarMusicaAPlaylist(String idPlaylist, String idMusica) {
        log.info("[inicia] PlaylistController - associarMusicaAPlaylist");
        playlistService.associaMusicaAPlaylist(idPlaylist, idMusica);
        log.info("[finaliza] PlaylistController - associarMusicaAPlaylist");
    }

    @Override
    public void desassociarMusicaAPlaylist(String idPlaylist, String idMusica) {
        log.info("[inicia] PlaylistController - desassociarMusicaAPlaylist");
        playlistService.desassociaMusicaAPlaylist(idPlaylist, idMusica);
        log.info("[finaliza] PlaylistController - desassociarMusicaAPlaylist");
    }

    @Override
    public void deletarPlaylist(String idPlaylist) {
        log.info("[inicia] PlaylistController - deletarPlaylist");
        playlistService.deletarPlaylist(idPlaylist);
        log.info("[finaliza] PlaylistController - deletarPlaylist");
    }

    @Override
    public void alterarPlaylist(String idPlaylist, PlaylistAlteraRequest playlistRequest) {
        log.info("[inicia] PlaylistController - alterarPlaylist");
        playlistService.alterarPlaylist(idPlaylist, playlistRequest);
        log.info("[finaliza] PlaylistController - alterarPlaylist");
    }
}
