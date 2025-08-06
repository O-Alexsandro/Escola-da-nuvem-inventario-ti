package com.projeto_aws.Inventarioti.service;

import com.projeto_aws.Inventarioti.domain.Prioridade;
import com.projeto_aws.Inventarioti.repository.PrioridadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PrioridadeService {

    @Autowired
    PrioridadeRepository prioridadeRepository;

    public List<Prioridade> listarPrioridades(){
        return prioridadeRepository.findAll();
    }
}
