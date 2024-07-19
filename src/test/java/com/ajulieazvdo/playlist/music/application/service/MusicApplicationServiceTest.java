package com.ajulieazvdo.playlist.music.application.service;

import com.ajulieazvdo.playlist.DataHelper;
import com.ajulieazvdo.playlist.handler.APIException;
import com.ajulieazvdo.playlist.music.application.api.*;
import com.ajulieazvdo.playlist.music.application.repository.MusicRepository;
import com.ajulieazvdo.playlist.music.domain.Music;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class MusicApplicationServiceTest {
    @Mock
    private MusicRepository musicRepository;

    @InjectMocks
    private MusicApplicationService musicApplicationService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void deveSalvarMusica(){
        MusicRequest musicRequest = DataHelper.createMusicRequest();
        Music musicMock = DataHelper.createMusic();

        when(musicRepository.salvarMusica(any(Music.class))).thenReturn(musicMock);
        MusicResponse response = musicApplicationService.salvarMusica(musicRequest);

        assertEquals(musicMock.getNome(), musicRequest.getNome());
        assertNotNull(response);
    }

    @Test
    void deveNaoSalvarUmaMusicaAoPassarValoresNulos(){
        MusicRequest request = new MusicRequest(null, null, null);

        when(musicRepository.salvarMusica(any())).thenThrow(APIException.class);

        assertThrows(APIException.class, () -> musicApplicationService.salvarMusica(request));
    }

    @Test
    void listaTodasMusicasQuandoExisteEstados(){
        MusicRequest request = DataHelper.createMusicRequest();
        List<Music> musics = DataHelper.MusicListMock(request);

        when(musicRepository.buscarTodasAsMusicas()).thenReturn(musics);

        List<MusicListResponse> result =  musicApplicationService.buscarMusicas();
        assertEquals(musics.size(), result.size());
    }

    @Test
    void listaUmaMusicaQuandoPassaOId() {
        String musicId = DataHelper.musicId;
        Music musicaEsperada = DataHelper.createMusic();

        when(musicRepository.buscarUmaMusica(musicId)).thenReturn(musicaEsperada);
        MusicDetalhadaResponse response = musicApplicationService.buscarUmaMusicaPorId(musicId);

        assertNotNull(response);
        assertEquals(musicId, response.getIdMusic());
    }
    @Test
    void aoListarUmaProdutoComIdInexistente_DeveLancarAPIException() {
        String idInexistente =DataHelper.musicId;

        when(musicRepository.buscarUmaMusica(idInexistente))
                .thenThrow(APIException.build(HttpStatus.NOT_FOUND, "Musica não encontrada!"));

        APIException exception = assertThrows(APIException.class,
                () -> musicApplicationService.buscarUmaMusicaPorId(idInexistente));

        assertEquals(HttpStatus.NOT_FOUND, exception.getStatusException());
        assertEquals("Musica não encontrada!", exception.getMessage());

        verify(musicRepository, times(1)).buscarUmaMusica(idInexistente);
    }

    @Test
    void deletaUmaMusicaQuandoPorId() {
        String idMusica = DataHelper.musicId;
        Music musicEsperada = DataHelper.createMusic();

        when(musicRepository.buscarUmaMusica(idMusica)).thenReturn(musicEsperada);
        musicApplicationService.deletarUmaMusicaPassandoId(idMusica);

        verify(musicRepository, times(1)).deletarMusica(musicEsperada);
    }

    @Test
    void naoDeletaUmaMusica_QuandoPassaIdDeMusicaInvalida() {
        String idMusica = DataHelper.musicId;

        when(musicRepository.buscarUmaMusica(idMusica))
                .thenThrow(APIException.build(HttpStatus.NOT_FOUND, "Musica não encontrada!"));

        APIException exception = assertThrows(APIException.class,
                () -> musicApplicationService.deletarUmaMusicaPassandoId(idMusica));

        assertEquals(HttpStatus.NOT_FOUND, exception.getStatusException());
        assertEquals("Musica não encontrada!", exception.getMessage());
        verify(musicRepository, never()).deletarMusica(any());
    }
    @Test
    void deveAlterarProduto(){
        MusicAlteraRequest produtoRequest = DataHelper.createMusicaAlteraRequest();
        String idProduto = DataHelper.musicId;
        Music musicaMock = mock(Music.class);

        when(musicRepository.buscarUmaMusica(idProduto)).thenReturn(musicaMock);
        musicApplicationService.alterarMusica(idProduto, produtoRequest);

        verify(musicaMock).alterar(produtoRequest);
        verify(musicRepository).salvarMusica(musicaMock);
    }
}