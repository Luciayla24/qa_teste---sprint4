package br.com.fiap.sprint3.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import br.com.fiap.sprint3.dto.moto.MotoRequest;
import br.com.fiap.sprint3.dto.moto.MotoResponse;
import br.com.fiap.sprint3.entity.Filial;
import br.com.fiap.sprint3.entity.Moto;
import br.com.fiap.sprint3.entity.Usuario;
import br.com.fiap.sprint3.exception.NotFoundException;
import br.com.fiap.sprint3.repository.FilialRepository;
import br.com.fiap.sprint3.repository.MotoRepository;
import br.com.fiap.sprint3.repository.UsuarioRepository;

@ExtendWith(MockitoExtension.class)
class MotoServiceTest {

    @Mock
    private MotoRepository motoRepository;

    @Mock
    private FilialRepository filialRepository;

    @Mock
    private UsuarioRepository usuarioRepository;

    @InjectMocks
    private MotoService motoService;

    private Filial filial;
    private Usuario usuario;

    @BeforeEach
    void setUp() {
        filial = new Filial();
        filial.setId(1L);
        filial.setNome("Filial Centro");

        usuario = new Usuario();
        usuario.setId(2L);
        usuario.setEmail("usuario@teste.com");
    }

    @Test
    void toEntityDeveRetornarMotoQuandoFilialEUsuarioExistem() {
        MotoRequest request = new MotoRequest();
        request.setPlaca("ABC1234");
        request.setStatus("DISPONIVEL");
        request.setFilialId(filial.getId());
        request.setUsuarioId(usuario.getId());

        when(filialRepository.findById(filial.getId())).thenReturn(Optional.of(filial));
        when(usuarioRepository.findById(usuario.getId())).thenReturn(Optional.of(usuario));

        Moto moto = motoService.toEntity(request);

        assertEquals(request.getPlaca(), moto.getPlaca());
        assertEquals(request.getStatus(), moto.getStatus());
        assertEquals(filial, moto.getFilial());
        assertEquals(usuario, moto.getUsuario());
    }

    @Test
    void toEntityDeveLancarExcecaoQuandoFilialNaoExiste() {
        MotoRequest request = new MotoRequest();
        request.setPlaca("ABC1234");
        request.setStatus("DISPONIVEL");
        request.setFilialId(99L);
        request.setUsuarioId(usuario.getId());

        when(filialRepository.findById(99L)).thenReturn(Optional.empty());

        assertThrows(NotFoundException.class, () -> motoService.toEntity(request));
    }

    @Test
    void toEntityDeveLancarExcecaoQuandoUsuarioNaoExiste() {
        MotoRequest request = new MotoRequest();
        request.setPlaca("ABC1234");
        request.setStatus("DISPONIVEL");
        request.setFilialId(filial.getId());
        request.setUsuarioId(99L);

        when(filialRepository.findById(filial.getId())).thenReturn(Optional.of(filial));
        when(usuarioRepository.findById(99L)).thenReturn(Optional.empty());

        assertThrows(NotFoundException.class, () -> motoService.toEntity(request));
    }

    @Test
    void toResponseDeveRetornarDadosDaMoto() {
        Moto moto = new Moto();
        moto.setId(10L);
        moto.setPlaca("XYZ9876");
        moto.setStatus("EM_USO");
        moto.setFilial(filial);
        moto.setUsuario(usuario);

        MotoResponse response = motoService.toResponse(moto);

        assertEquals(moto.getId(), response.getId());
        assertEquals(moto.getPlaca(), response.getPlaca());
        assertEquals(moto.getStatus(), response.getStatus());
        assertEquals(filial.getNome(), response.getFilialNome());
        assertEquals(usuario.getEmail(), response.getUsuarioEmail());
    }
}
