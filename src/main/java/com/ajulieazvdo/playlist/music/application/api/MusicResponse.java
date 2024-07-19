package com.ajulieazvdo.playlist.music.application.api;

import com.ajulieazvdo.playlist.music.domain.Music;
import lombok.Getter;

@Getter
public class MusicResponse {
    private String idMusic;

    public MusicResponse(Music music) {
        this.idMusic = music.getIdMusic();
    }
}
