package com.ajulieazvdo.playlist.music.application.service;

import com.ajulieazvdo.playlist.music.application.api.*;
import com.ajulieazvdo.playlist.music.application.repository.MusicRepository;
import com.ajulieazvdo.playlist.music.domain.Music;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Log4j2
@RequiredArgsConstructor
public class MusicApplicationService implements MusicService {
    private final MusicRepository musicRepository;
    @Override
    public MusicResponse salvarMusica(MusicRequest musicRequest) {
        log.info("[inicia] MusicApplicationService - salvarMusica");
        Music music = musicRepository.salvarMusica(new Music(musicRequest));
        log.info("[finaliza] MusicApplicationService - salvarMusica");
        return new MusicResponse(music);
    }

    @Override
    public List<MusicListResponse> buscarMusicas() {
        log.info("[inicia] MusicApplicationService - buscarMusicas");
        List<Music> musicas = musicRepository.buscarTodasAsMusicas();
        log.info("[finaliza] MusicApplicationService - buscarMusicas");
        return MusicListResponse.converter(musicas);
    }

    @Override
    public MusicDetalhadaResponse buscarUmaMusicaPorId(String idMusica) {
        log.info("[inicia] MusicApplicationService - buscarUmaMusicaPorId");
        Music musica = musicRepository.buscarUmaMusica(idMusica);
        log.info("[finaliza] MusicApplicationService - buscarUmaMusicaPorId");
        return new MusicDetalhadaResponse(musica);
    }

    @Override
    public void deletarUmaMusicaPassandoId(String idMusica) {
        log.info("[inicia] MusicApplicationService - deletarUmaMusicaPassandoId");
        Music musica = musicRepository.buscarUmaMusica(idMusica);
        musicRepository.deletarMusica(musica);
        log.info("[finaliza] MusicApplicationService - deletarUmaMusicaPassandoId");
    }

    @Override
    public void alterarMusica(String idMusica, MusicAlteraRequest musicRequest) {
        log.info("[inicia] MusicApplicationService - alterarMusica");
        Music musica = musicRepository.buscarUmaMusica(idMusica);
        musica.alterar(musicRequest);
        musicRepository.salvarMusica(musica);
        log.info("[finaliza] MusicApplicationService - alterarMusica");
    }
}
