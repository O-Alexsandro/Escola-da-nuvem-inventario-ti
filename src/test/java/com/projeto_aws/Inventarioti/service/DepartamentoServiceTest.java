package com.projeto_aws.Inventarioti.service;

import com.projeto_aws.Inventarioti.domain.Departamento;
import com.projeto_aws.Inventarioti.dto.departamentoDTO.AtualizarDepartamentoDTO;
import com.projeto_aws.Inventarioti.dto.departamentoDTO.CriarDepartamentoDTO;
import com.projeto_aws.Inventarioti.repository.DepartamentoRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class DepartamentoServiceTest {

    @InjectMocks
    private DepartamentoService departamentoService;

    @Mock
    private DepartamentoRepository departamentoRepository;

    @Test
    void deveRetornarTodosOsDepartamentos(){

        List<Departamento> departamentos = List.of();

        when(departamentoRepository.findAll()).thenReturn(departamentos);

        List<Departamento> metodo = departamentoService.listarDepartamentos();

        Assertions.assertNotNull(metodo);
    }

    @Test
    void deveCriarUmDepartamento(){
        String nome = "Departamento";

        CriarDepartamentoDTO novoDepartamento = new CriarDepartamentoDTO(nome);

        Departamento novaEntidade = new Departamento(novoDepartamento);

        when(departamentoRepository.save(any(Departamento.class))).thenReturn(novaEntidade);

        Departamento dpCriado = departamentoService.criarDepartamento(novoDepartamento);

        Assertions.assertNotNull(dpCriado);
        Assertions.assertEquals(nome, dpCriado.getNomeDepartamento());
        verify(departamentoRepository, times(1)).save(any(Departamento.class));
    }

    @Test
    void deveAtualizarUmDepartamento(){
        String nome = "Novo Nome";
        Long id = 1L;

        Departamento dpRetornado = new Departamento();
        dpRetornado.setIdDepartamento(id);
        dpRetornado.setNomeDepartamento(nome);

        AtualizarDepartamentoDTO atualizar = new AtualizarDepartamentoDTO(id, nome);

        when(departamentoRepository.findById(id)).thenReturn(Optional.of(dpRetornado));

        when(departamentoRepository.save(any(Departamento.class))).thenReturn(dpRetornado);

        Departamento atualizado = departamentoService.atualizarDepartamento(atualizar);

        Assertions.assertNotNull(atualizado);
        Assertions.assertEquals(nome, atualizado.getNomeDepartamento());
        verify(departamentoRepository, times(1)).findById(id);
    }


}