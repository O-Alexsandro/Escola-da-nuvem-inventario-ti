package com.projeto_aws.Inventarioti.service;

import com.projeto_aws.Inventarioti.domain.Departamento;
import com.projeto_aws.Inventarioti.domain.Usuario;
import com.projeto_aws.Inventarioti.dto.usuarioDTO.AtualizarUsuarioDTO;
import com.projeto_aws.Inventarioti.dto.usuarioDTO.CriarUsuarioDTO;
import com.projeto_aws.Inventarioti.repository.DepartamentoRepository;
import com.projeto_aws.Inventarioti.repository.UsuarioRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private DepartamentoRepository departamentoRepository;

    public List<Usuario> listarUsuarios(){
        return usuarioRepository.findAll();
    }

    public Usuario criarUsuario(CriarUsuarioDTO usuario){
        Departamento departamento = departamentoRepository.findById(usuario.idDepartamento()).orElseThrow(()-> new EntityNotFoundException("Departamento não encontrado com o ID informado"));
        Usuario novoUsuario = new Usuario(usuario, departamento);
        return usuarioRepository.save(novoUsuario);
    }

    public Usuario atualizarUsuario(AtualizarUsuarioDTO usuario){
        Usuario atualizaUsuario = usuarioRepository.findById(usuario.idUsuario()).orElseThrow(()-> new EntityNotFoundException("Usuário não encontrado com o ID informado"));

        if (usuario.nome() != null){
            atualizaUsuario.setNomeUsuario(usuario.nome());
        }

        if (usuario.idDepartamento() != null){
            Departamento departamento = departamentoRepository.findById(usuario.idDepartamento()).orElseThrow(()-> new EntityNotFoundException("Usuário não encontrado com o ID informado"));
            atualizaUsuario.setDepartamento(departamento);
        }

        return usuarioRepository.save(atualizaUsuario);
    }

    public void deletarUsuario(Long idUsuario){
        Usuario usuario = usuarioRepository.findById(idUsuario).orElseThrow(()-> new EntityNotFoundException("Usuário não encontrado com o ID informado"));
        usuarioRepository.delete(usuario);
    }

}
