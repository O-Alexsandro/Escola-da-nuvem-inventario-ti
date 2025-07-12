package com.projeto_aws.Inventarioti.service;

import com.projeto_aws.Inventarioti.domain.RelacionamentoGeral;
import com.projeto_aws.Inventarioti.dto.relacionamentoDTO.AtualizarRelacionamentoDTO;
import com.projeto_aws.Inventarioti.dto.relacionamentoDTO.CriarRelacionamentoDTO;
import com.projeto_aws.Inventarioti.repository.RelacionamentoRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RelacionamentoGeralService {

    @Autowired
    private RelacionamentoRepository relacionamentoRepository;

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

    public List<RelacionamentoGeral> listarRelacionamentos(){
        return relacionamentoRepository.findAll();
    }

    public List<RelacionamentoGeral> buscarPorIdUsuario(Long idUsuario) {
        return relacionamentoRepository.findByUsuarioIdUsuario(idUsuario);
    }

    public RelacionamentoGeral criarRelacionamento(CriarRelacionamentoDTO relacionamento){
        RelacionamentoGeral novoRelacionamento = new RelacionamentoGeral(relacionamento);
        return relacionamentoRepository.save(novoRelacionamento);
    }

    public RelacionamentoGeral atualizarRelacionamento(AtualizarRelacionamentoDTO relacionamento){
        RelacionamentoGeral atualizaRelacionamento = relacionamentoRepository.findById(relacionamento.idRelacionamento()).orElseThrow(()-> new EntityNotFoundException("Relacionamento não encontrado com o ID informado"));

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
        return relacionamentoRepository.save(atualizaRelacionamento);
    }

    public void deletarRelacionamento(Long idRelacionamento){
        RelacionamentoGeral atualizaRelacionamento = relacionamentoRepository.findById(idRelacionamento).orElseThrow(()-> new EntityNotFoundException("Relacionamento não encontrado com o ID informado"));
        relacionamentoRepository.delete(atualizaRelacionamento);
    }
    // Conta quantos registros tem na tabela de relacionamento
    public Long quantidadeRegistro(){
        return relacionamentoRepository.count();
    }

    // retorna o ultimo cadastro de relacionamento
    public RelacionamentoGeral buscarUltimoCadastro(){
        return relacionamentoRepository.findFirstByOrderByDataRegistroDesc().orElseThrow(null);
    }
}
