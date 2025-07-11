package com.projeto_aws.Inventarioti.service;

import com.projeto_aws.Inventarioti.configuration.TokenService;
import com.projeto_aws.Inventarioti.domain.Usuario;
import com.projeto_aws.Inventarioti.domain.usuarioSistema.UsuarioSistema;
import com.projeto_aws.Inventarioti.dto.usuarioSistemaDTO.AtualizarUsuarioSistemaDTO;
import com.projeto_aws.Inventarioti.dto.usuarioSistemaDTO.CriarUsuarioSistemaDTO;
import com.projeto_aws.Inventarioti.dto.usuarioSistemaDTO.ResetarSenhaDTO;
import com.projeto_aws.Inventarioti.repository.UsuarioSistemaRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioSistemaService implements UserDetailsService {

    @Autowired
    private UsuarioSistemaRepository usuarioSistemaRepository;

    @Autowired
    private TokenService tokenService;

    public List<UsuarioSistema> listarUsuariosSistema(){
        return usuarioSistemaRepository.findAll();
    }

    public UsuarioSistema criarUsuarioSistema(CriarUsuarioSistemaDTO usuarioSistema){
        UsuarioSistema novoUsuarioSistema = new UsuarioSistema(usuarioSistema);
        String senhaBcrypt = new BCryptPasswordEncoder().encode(usuarioSistema.senha());
        novoUsuarioSistema.setSenha(senhaBcrypt);
        return usuarioSistemaRepository.save(novoUsuarioSistema);
    }

    public UsuarioSistema atualizarUsuarioSistema(AtualizarUsuarioSistemaDTO usuarioSistema) {
        UsuarioSistema buscaUsuario = usuarioSistemaRepository.findById(usuarioSistema.idUsuarioSistema()).orElseThrow(()-> new EntityNotFoundException("Usuário não localizado pelo ID informado"));

        if (usuarioSistema.nome() != null){
            buscaUsuario.setNomeUsuario(usuarioSistema.nome());
        }

        if (usuarioSistema.email() != null){
            buscaUsuario.setEmail(usuarioSistema.email());
        }

        if (usuarioSistema.senha() != null){
            String senhaNova = new BCryptPasswordEncoder().encode(usuarioSistema.email());
            buscaUsuario.setSenha(senhaNova);
        }

        return usuarioSistemaRepository.save(buscaUsuario);
    }

    public void deletarUsuario (Long idUsuarioSistema){
        UsuarioSistema usuario = usuarioSistemaRepository.findById(idUsuarioSistema).orElseThrow(()-> new EntityNotFoundException("Usuário não localizado pelo ID informado"));
        usuarioSistemaRepository.delete(usuario);
    }

    public UsuarioSistema resetarSenha(ResetarSenhaDTO usuarioSistema){
        UsuarioSistema usuario = usuarioSistemaRepository.findByNomeUsuarioAndEmail(usuarioSistema.nome(), usuarioSistema.email());

        if (usuarioSistema.nome() != null && usuarioSistema.email() != null){
            String senhaNova = new BCryptPasswordEncoder().encode(usuarioSistema.senha());
            usuario.setSenha(senhaNova);
        }

        return usuarioSistemaRepository.save(usuario);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return usuarioSistemaRepository.findByEmail(username);
    }

}
