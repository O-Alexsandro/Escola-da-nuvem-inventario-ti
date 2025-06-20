package com.projeto_aws.Inventarioti.service;

import com.projeto_aws.Inventarioti.domain.RelacionamentoGeral;
import com.projeto_aws.Inventarioti.dto.relacionamentoDTO.AtualizarRelacionamento;
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

    public List<RelacionamentoGeral> listarRelacionamentos(){
        return relacionamentoRepository.findAll();
    }

    public RelacionamentoGeral criarRelacionamento(CriarRelacionamentoDTO relacionamento){
        RelacionamentoGeral novoRelacionamento = new RelacionamentoGeral(relacionamento);
        return relacionamentoRepository.save(novoRelacionamento);
    }

    public RelacionamentoGeral atualizarRelacionamento(AtualizarRelacionamento relacionamento){
        RelacionamentoGeral atualizaRelacionamento = relacionamentoRepository.findById(relacionamento.idRelacionamento()).orElseThrow(()-> new EntityNotFoundException("Relacionamento não encontrado com o ID informado"));

        // avaliar se é necessário chamar os metodos de atualizar de cada entidade.

        if (relacionamento.idUsuario() != null){

        }

        return null;
    }

    public void deletarRelacionamento(Long idRelacionamento){
        RelacionamentoGeral atualizaRelacionamento = relacionamentoRepository.findById(idRelacionamento).orElseThrow(()-> new EntityNotFoundException("Relacionamento não encontrado com o ID informado"));
        relacionamentoRepository.delete(atualizaRelacionamento);
    }




}
