package com.ajulieazvdo.playlist.music.application.service;

import com.ajulieazvdo.playlist.music.application.api.*;

import java.util.List;

public interface MusicService {
    MusicResponse salvarMusica(MusicRequest musicRequest);

    List<MusicListResponse> buscarMusicas();

    MusicDetalhadaResponse buscarUmaMusicaPorId(String idMusica);

    void deletarUmaMusicaPassandoId(String idMusica);

    void alterarMusica(String idMusica, MusicAlteraRequest musicRequest);
}
