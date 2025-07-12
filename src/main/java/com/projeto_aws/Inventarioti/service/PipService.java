package com.projeto_aws.Inventarioti.service;

import com.projeto_aws.Inventarioti.domain.Pip;
import com.projeto_aws.Inventarioti.dto.pipDTO.AtualizarPibDTO;
import com.projeto_aws.Inventarioti.dto.pipDTO.CriarPibDTO;
import com.projeto_aws.Inventarioti.repository.PipRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PipService {

    @Autowired
    private PipRepository pipRepository;

    public List<Pip> listarPip (){
        return pipRepository.findAll();
    }

    public Pip criarPip(CriarPibDTO pip){
        Pip novoPip = new Pip(pip);
        return pipRepository.save(novoPip);
    }

    public Pip atualizarPib(AtualizarPibDTO pip){
        Pip atualizaPip = pipRepository.findById(pip.id()).orElseThrow(()-> new EntityNotFoundException("Suprimento não encontrado com o ID informado"));

        if (pip.nome() != null){
            atualizaPip.setNomePip(pip.nome());
        }

        return pipRepository.save(atualizaPip);
    }

    public void deletaPib(Long idPip){
        Pip deletaPip = pipRepository.findById(idPip).orElseThrow(()-> new EntityNotFoundException("PIP não encontrado com o ID informado"));
        pipRepository.delete(deletaPip);
    }
}
