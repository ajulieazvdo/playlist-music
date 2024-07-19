package com.ajulieazvdo.playlist.music.infra;

import com.ajulieazvdo.playlist.handler.APIException;
import com.ajulieazvdo.playlist.music.application.repository.MusicRepository;
import com.ajulieazvdo.playlist.music.domain.Music;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Log4j2
@RequiredArgsConstructor
public class MusicInfraRepository implements MusicRepository {
    private final MusicSpringDataJpaRepository musicSpringDataJpaRepository;
    @Override
    public Music salvarMusica(Music music) {
        log.info("[inicia] MusicInfraRepository - salvarMusica");
        musicSpringDataJpaRepository.save(music);
        log.info("[finaliza] MusicInfraRepository - salvarMusica");
        return music;
    }

    @Override
    public List<Music> buscarTodasAsMusicas() {
        log.info("[inicia] MusicInfraRepository - buscarTodasAsMusicas");
        List<Music> musicas = musicSpringDataJpaRepository.findAll();
        log.info("[finaliza] MusicInfraRepository - buscarTodasAsMusicas");
        return musicas;
    }

    @Override
    public Music buscarUmaMusica(String idMusica) {
        log.info("[inicia] MusicInfraRepository - buscarUmaMusica");
        Music musica = musicSpringDataJpaRepository.findById(idMusica)
                .orElseThrow(() -> APIException.build(HttpStatus.NOT_FOUND, "Musica não encontrada!"));
        log.info("[finaliza] MusicInfraRepository - buscarUmaMusica");
        return musica;
    }

    @Override
    public void deletarMusica(Music musica) {
        log.info("[inicia] MusicInfraRepository - deletarMusica");
        musicSpringDataJpaRepository.delete(musica);
        log.info("[finaliza] MusicInfraRepository - deletarMusica");
    }
}
