package com.projeto_aws.Inventarioti.service;

import com.projeto_aws.Inventarioti.domain.Chamados;
import com.projeto_aws.Inventarioti.domain.Status;
import com.projeto_aws.Inventarioti.domain.usuarioSistema.RoleUsuario;
import com.projeto_aws.Inventarioti.dto.chamadosDTO.AtualizarChamadoDTO;
import com.projeto_aws.Inventarioti.dto.chamadosDTO.RegistrarChamadoDTO;
import com.projeto_aws.Inventarioti.repository.ChamadosRepository;
import com.projeto_aws.Inventarioti.repository.StatusRepository;
import com.projeto_aws.Inventarioti.utils.UsuarioAutenticado;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class ChamadosService {

    @Autowired
    ChamadosRepository chamadosRepository;

    @Autowired
    UsuarioAutenticado usuarioAutenticado;

    @Autowired
    StatusRepository statusRepository;


    public List<Chamados> listarChamados() {
        return chamadosRepository.findAll();
    }


    public Chamados listarChamadosPorId(Long id) {
        return chamadosRepository.findById(id).orElseThrow(()-> new EntityNotFoundException("Chamado não encontrado com o ID informado"));
    }


    public Chamados registrarChamado(RegistrarChamadoDTO registrarChamadoDTO,
                                     MultipartFile anexo){
        var usuario = usuarioAutenticado.retornarUsuarioAutenticado();

        try {
            Chamados chamado = new Chamados(registrarChamadoDTO, anexo);
            chamado.setUsuarioSistema(usuario);

            if (usuario.getRoleUsuario() == RoleUsuario.ROLE_COMUM){
                chamado.setUsuarioSistema(usuario);
            }

            return chamadosRepository.save(chamado);
        } catch (IOException e) {
            throw new RuntimeException("Erro ao processar o anexo", e);
        }
    }

    public Chamados atualizarTratativa(AtualizarChamadoDTO atualizarChamadoDTO){

        Chamados chamado = chamadosRepository.findById(atualizarChamadoDTO.idChamado()).orElseThrow(()-> new EntityNotFoundException("Chamado não localizado"));

        var usuario = usuarioAutenticado.retornarUsuarioAutenticado();

        if (usuario.getRoleUsuario() == RoleUsuario.ROLE_ADMIN){
            Status status = statusRepository.findById(atualizarChamadoDTO.idStatus()).orElseThrow(()-> new EntityNotFoundException("Status do chamado não localizado"));
            chamado.setStatus(status);
        }

        return chamadosRepository.save(chamado);
    }


    public byte[] downloadAnexo(Long id) {
        Chamados chamado = chamadosRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Chamado não encontrado"));
        return chamado.getAnexo();
    }


}
