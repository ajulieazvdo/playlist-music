package com.ajulieazvdo.playlist.playlist.application.service;

import com.ajulieazvdo.playlist.music.application.api.MusicListResponse;
import com.ajulieazvdo.playlist.music.application.repository.MusicRepository;
import com.ajulieazvdo.playlist.music.domain.Music;
import com.ajulieazvdo.playlist.playlist.application.api.PlaylistAlteraRequest;
import com.ajulieazvdo.playlist.playlist.application.api.PlaylistListResponse;
import com.ajulieazvdo.playlist.playlist.application.api.PlaylistRequest;
import com.ajulieazvdo.playlist.playlist.application.api.PlaylistResponse;
import com.ajulieazvdo.playlist.playlist.application.repositpory.PlaylistRepository;
import com.ajulieazvdo.playlist.playlist.domain.Playlist;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Log4j2
@RequiredArgsConstructor
public class PlaylistApplicationService implements PlaylistService {
    private final PlaylistRepository playlistRepository;
    private final MusicRepository musicRepository;
    @Override
    public PlaylistResponse salvarPlaylist(PlaylistRequest playlistRequest) {
        log.info("[inicia] PlaylistApplicationService - salvarPlaylist");
        Playlist playlist = playlistRepository.salvarPlaylist(new Playlist(playlistRequest));
        log.info("[finaliza] PlaylistApplicationService - salvarPlaylist");
        return new PlaylistResponse(playlist);
    }

    @Override
    public void associaMusicaAPlaylist(String idPlaylist, String idMusica) {
        log.info("[inicia] PlaylistApplicationService - associaMusicaAPlaylist");
        Music music = musicRepository.buscarUmaMusica(idMusica);
        Playlist playlist = playlistRepository.buscarUmaPlaylistPorId(idPlaylist);
        playlist.getMusics().add(music);
        playlistRepository.salvarPlaylist(playlist);
        log.info("[finaliza] PlaylistApplicationService - associaMusicaAPlaylist");
    }

    @Override
    public void desassociaMusicaAPlaylist(String idPlaylist, String idMusica) {
        log.info("[inicia] PlaylistApplicationService - desassociaMusicaAPlaylist");
        Music music = musicRepository.buscarUmaMusica(idMusica);
        Playlist playlist = playlistRepository.buscarUmaPlaylistPorId(idPlaylist);
        playlist.getMusics().remove(music);
        playlistRepository.salvarPlaylist(playlist);
        log.info("[finaliza] PlaylistApplicationService - desassociaMusicaAPlaylist");
    }

    @Override
    public void deletarPlaylist(String idPlaylist) {
        log.info("[inicia] PlaylistApplicationService - deletarPlaylist");
        Playlist playlist = playlistRepository.buscarUmaPlaylistPorId(idPlaylist);
        playlistRepository.deletarPlaylist(playlist);
        log.info("[finaliza] PlaylistApplicationService - deletarPlaylist");
    }

    @Override
    public void alterarPlaylist(String idPlaylist, PlaylistAlteraRequest playlistRequest) {
        log.info("[inicia] PlaylistApplicationService - alterarPlaylist");
        Playlist playlist = playlistRepository.buscarUmaPlaylistPorId(idPlaylist);
        playlist.alterar(playlistRequest);
        playlistRepository.salvarPlaylist(playlist);
        log.info("[finaliza] PlaylistApplicationService - alterarPlaylist");
    }

    @Override
    public PlaylistListResponse buscarPlaylistPorId(String idPlaylist) {
        log.info("[inicia] PlaylistApplicationService - buscarPlaylistPorId");
        Playlist playlist = playlistRepository.buscarUmaPlaylistPorId(idPlaylist);
        List<MusicListResponse> musicListResponses = PlaylistListResponse.converterPlaylist(playlist);
        log.info("[finaliza] PlaylistApplicationService - buscarPlaylistPorId");
        return new PlaylistListResponse(playlist, musicListResponses);
    }
}