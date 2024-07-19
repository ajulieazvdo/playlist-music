package com.ajulieazvdo.playlist.playlist.application.api;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/playlist")
public interface PlaylistAPI {
    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    PlaylistResponse criarPlaylist (@RequestBody @Valid PlaylistRequest playlistRequest);

    @GetMapping("/{idPlaylist}")
    @ResponseStatus(code = HttpStatus.OK)
    PlaylistListResponse listarPlaylist(@PathVariable String idPlaylist);

    @DeleteMapping("/{idPlaylist}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    void deletarPlaylist(@PathVariable String idPlaylist);

    @PatchMapping(path = "/{idPlaylist}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    void alterarPlaylist (@PathVariable String idPlaylist, @RequestBody @Valid PlaylistAlteraRequest playlistRequest);

    @PatchMapping(path = "/{idPlaylist}/associa-musica/{idMusica}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    void associarMusicaAPlaylist (@PathVariable String idPlaylist, @PathVariable String idMusica);

    @PatchMapping(path = "/{idPlaylist}/desassocia-musica/{idMusica}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    void desassociarMusicaAPlaylist (@PathVariable String idPlaylist, @PathVariable String idMusica);

}