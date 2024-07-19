package com.ajulieazvdo.playlist;


import com.ajulieazvdo.playlist.music.application.api.MusicAlteraRequest;
import com.ajulieazvdo.playlist.music.application.api.MusicDetalhadaResponse;
import com.ajulieazvdo.playlist.music.application.api.MusicListResponse;
import com.ajulieazvdo.playlist.music.application.api.MusicRequest;
import com.ajulieazvdo.playlist.music.domain.Music;

import java.util.ArrayList;
import java.util.List;

public class DataHelper {
    public static final String musicId = "a713162f-20a9-4db9-a85b-90cd51ab18f4";
    public static final String musicIdOutro = "c07742d2-992c-43dd-ab1d-fac1c7bb8704";

    public static Music createMusic(){
        return Music.builder().idMusic(musicId).nome("Love Story").artistaNome("Taylor Swift").album("Speak Now").build();
    }

    public static List<Music> MusicListMock(MusicRequest musicRequest) {
        List<Music> Musics = new ArrayList<>();
        Musics.add(MusicMock(musicRequest));
        MusicListResponse.converter(Musics);
        return Musics;
    }

    public static MusicDetalhadaResponse listOneMusicResponse(){
        return new MusicDetalhadaResponse(musicId, "Love Story", "Taylor Swift", "Speak Now");
    }
    public static Music MusicMock(MusicRequest MusicRequest) {
        return new Music(MusicRequest);
    }

    public static MusicRequest createMusicRequest() {
        return new MusicRequest("Love Story", "Taylor Swift", "Speak Now");
    }

    public static MusicAlteraRequest createMusicaAlteraRequest() {
        return new MusicAlteraRequest("Love Story", "Taylor Swift", "Speak Now");
    }
}
