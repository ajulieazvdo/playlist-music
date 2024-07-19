package com.ajulieazvdo.playlist.music.application.repository;

import com.ajulieazvdo.playlist.music.domain.Music;

import java.util.List;

public interface MusicRepository {
    Music salvarMusica(Music music);

    List<Music> buscarTodasAsMusicas();

    Music buscarUmaMusica(String idMusica);

    void deletarMusica(Music musica);
}
