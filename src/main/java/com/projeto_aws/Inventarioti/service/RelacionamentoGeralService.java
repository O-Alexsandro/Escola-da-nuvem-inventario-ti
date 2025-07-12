package com.projeto_aws.Inventarioti.service;

import com.projeto_aws.Inventarioti.domain.UsuMaqSoftPip;
import com.projeto_aws.Inventarioti.dto.relacionamentoDTO.AtualizarRelacionamentoDTO;
import com.projeto_aws.Inventarioti.dto.relacionamentoDTO.CriarRelacionamentoDTO;
import com.projeto_aws.Inventarioti.repository.UsuMaqSoftPipRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RelacionamentoGeralService {

    @Autowired
    private UsuMaqSoftPipRepository usuMaqSoftPipRepository;

    @Autowired
    private DepartamentoService departamentoService;

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private MaquinaService maquinaService;

    @Autowired
    private SoftwareService softwareService;

    @Autowired
    private PipService pipService;

    public List<UsuMaqSoftPip> listarRelacionamentos(){
        return usuMaqSoftPipRepository.findAll();
    }

    public List<UsuMaqSoftPip> buscarPorIdUsuario(Long idUsuario) {
        return usuMaqSoftPipRepository.findByUsuarioIdUsuario(idUsuario);
    }

    public UsuMaqSoftPip criarRelacionamento(CriarRelacionamentoDTO relacionamento){
        UsuMaqSoftPip novoRelacionamento = new UsuMaqSoftPip(relacionamento);
        return usuMaqSoftPipRepository.save(novoRelacionamento);
    }

    public UsuMaqSoftPip atualizarRelacionamento(AtualizarRelacionamentoDTO relacionamento){
        UsuMaqSoftPip atualizaRelacionamento = usuMaqSoftPipRepository.findById(relacionamento.idRelacionamento()).orElseThrow(()-> new EntityNotFoundException("Relacionamento não encontrado com o ID informado"));

        // Se o departamento não estiver nulo,
        // ele chama o metodo de atualizar o departamento e atualiza conforme os dados passados
        if (relacionamento.departamento() != null){
            departamentoService.atualizarDepartamento(relacionamento.departamento());
        }

        if (relacionamento.usuario() != null){
            usuarioService.atualizarUsuario(relacionamento.usuario());
        }

        if (relacionamento.maquina() != null){
            maquinaService.atualizarMaquina(relacionamento.maquina());
        }

        if (relacionamento.software() != null){
            softwareService.atualizarSoftware(relacionamento.software());
        }

        if (relacionamento.suprimento() != null){
            pipService.atualizarPib(relacionamento.suprimento());
        }
        return usuMaqSoftPipRepository.save(atualizaRelacionamento);
    }

    public void deletarRelacionamento(Long idRelacionamento){
        UsuMaqSoftPip atualizaRelacionamento = usuMaqSoftPipRepository.findById(idRelacionamento).orElseThrow(()-> new EntityNotFoundException("Relacionamento não encontrado com o ID informado"));
        usuMaqSoftPipRepository.delete(atualizaRelacionamento);
    }
    // Conta quantos registros tem na tabela de relacionamento
    public Long quantidadeRegistro(){
        return usuMaqSoftPipRepository.count();
    }

    // retorna o ultimo cadastro de relacionamento
    public UsuMaqSoftPip buscarUltimoCadastro(){
        return usuMaqSoftPipRepository.findFirstByOrderByDataCadastroDesc().orElseThrow(null);
    }
}
