package com.ajulieazvdo.playlist.music.application.api;

import com.ajulieazvdo.playlist.music.application.service.MusicService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Log4j2
public class MusicRestController implements MusicAPI {
    private final MusicService musicService;

    @Override
    public MusicResponse criarMusica(MusicRequest musicRequest) {
        log.info("[inicia] MusicRestController - criarMusica");
        MusicResponse music = musicService.salvarMusica(musicRequest);
        log.info("[finaliza] MusicRestController - criarMusica");
        return music;
    }

    @Override
    public List<MusicListResponse> listarMusicas() {
        log.info("[inicia] MusicRestController - listarMusicas");
        List<MusicListResponse> musics = musicService.buscarMusicas();
        log.info("[finaliza] MusicRestController - listarMusicas");
        return musics;
    }

    @Override
    public MusicDetalhadaResponse listarUmaMusica(String idMusica) {
        log.info("[inicia] MusicRestController - listarUmaMusica");
        MusicDetalhadaResponse musica = musicService.buscarUmaMusicaPorId(idMusica);
        log.info("[finaliza] MusicRestController - listarUmaMusica");
        return musica;
    }

    @Override
    public void deletarUmaMusica(String idMusica) {
        log.info("[inicia] MusicRestController - deletarUmaMusica");
        musicService.deletarUmaMusicaPassandoId(idMusica);
        log.info("[finaliza] MusicRestController - deletarUmaMusica");
    }

    @Override
    public void alterarUmaMusica(String idMusica, MusicAlteraRequest musicRequest) {
        log.info("[inicia] MusicRestController - alterarUmaMusica");
        musicService.alterarMusica(idMusica, musicRequest);
        log.info("[finaliza] MusicRestController - alterarUmaMusica");
    }
}
