package com.ajulieazvdo.playlist.playlist.infra;

import com.ajulieazvdo.playlist.handler.APIException;
import com.ajulieazvdo.playlist.playlist.application.repositpory.PlaylistRepository;
import com.ajulieazvdo.playlist.playlist.domain.Playlist;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;

@Repository
@Log4j2
@RequiredArgsConstructor
public class PlaylistInfraRepository implements PlaylistRepository {
    private final PlaylistSpringDataJpaRepository playlistSpringDataJpaRepository;
    @Override
    public Playlist salvarPlaylist(Playlist playlist) {
        log.info("[inicia] PlaylistInfraRepository - salvarPlaylist");
        playlistSpringDataJpaRepository.save(playlist);
        log.info("[finaliza] PlaylistInfraRepository - salvarPlaylist");
        return playlist;
    }

    @Override
    public Playlist buscarUmaPlaylistPorId(String idPlaylist) {
        log.info("[inicia] PlaylistInfraRepository - buscarUmaPlaylistPorId");
        Playlist playlist = playlistSpringDataJpaRepository.findById(idPlaylist)
                .orElseThrow(() -> APIException.build(HttpStatus.NOT_FOUND, "Playlist não encontrada!"));
        log.info("[finaliza] PlaylistInfraRepository - buscarUmaPlaylistPorId");
        return playlist;
    }

    @Override
    public void deletarPlaylist(Playlist playlist) {
        log.info("[inicia] PlaylistInfraRepository - deletarPlaylist");
        playlistSpringDataJpaRepository.delete(playlist);
        log.info("[finaliza] PlaylistInfraRepository - deletarPlaylist");
    }
}
