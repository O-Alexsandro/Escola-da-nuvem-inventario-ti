package com.projeto_aws.Inventarioti.service;

import com.projeto_aws.Inventarioti.domain.Suprimento;
import com.projeto_aws.Inventarioti.dto.suprimentoDTO.AtualizarSuprimentoDTO;
import com.projeto_aws.Inventarioti.dto.suprimentoDTO.CriarSuprimentoDTO;
import com.projeto_aws.Inventarioti.repository.SuprimentoRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SuprimentoService {

    @Autowired
    private SuprimentoRepository suprimentoRepository;

    public List<Suprimento> listarSuprimentos (){
        return suprimentoRepository.findAll();
    }

    public Suprimento criarSuprimento(CriarSuprimentoDTO suprimento){
        Suprimento novoSuprimento = new Suprimento(suprimento);
        return suprimentoRepository.save(novoSuprimento);
    }

    public Suprimento atualizarSuprimento(AtualizarSuprimentoDTO suprimento){
        Suprimento atualizaSuprimento = suprimentoRepository.findById(suprimento.id()).orElseThrow(()-> new EntityNotFoundException("Suprimento não encontrado com o ID informado"));

        if (suprimento.nome() != null){
            atualizaSuprimento.setNomeSuprimento(suprimento.nome());
        }

        if (suprimento.descricao() != null){
            atualizaSuprimento.setDescricaoSuprimento(suprimento.descricao());
        }
        return suprimentoRepository.save(atualizaSuprimento);
    }

    public void deletaSuprimento(Long idSuprimento){
        Suprimento deletaSuprimento = suprimentoRepository.findById(idSuprimento).orElseThrow(()-> new EntityNotFoundException("Suprimento não encontrado com o ID informado"));
        suprimentoRepository.delete(deletaSuprimento);
    }
}
