package com.ajulieazvdo.playlist.music.application.api;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/music")
public interface MusicAPI {
    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    MusicResponse criarMusica (@RequestBody @Valid MusicRequest musicRequest);

    @GetMapping
    @ResponseStatus(code = HttpStatus.OK)
    List<MusicListResponse> listarMusicas ();

    @GetMapping(path = "/{idMusica}")
    @ResponseStatus(code = HttpStatus.OK)
    MusicDetalhadaResponse listarUmaMusica (@PathVariable String idMusica);

    @DeleteMapping(path = "/{idMusica}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    void deletarUmaMusica (@PathVariable String idMusica);

    @DeleteMapping(path = "/{idMusica}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    void alterarUmaMusica (@PathVariable String idMusica, @RequestBody @Valid MusicAlteraRequest musicRequest);
}
