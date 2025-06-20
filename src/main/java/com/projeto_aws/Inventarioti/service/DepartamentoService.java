package com.projeto_aws.Inventarioti.service;

import com.projeto_aws.Inventarioti.domain.Departamento;
import com.projeto_aws.Inventarioti.dto.departamentoDTO.AtualizarDepartamentoDTO;
import com.projeto_aws.Inventarioti.dto.departamentoDTO.CriarDepartamentoDTO;
import com.projeto_aws.Inventarioti.repository.DepartamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartamentoService {

    @Autowired
    private DepartamentoRepository departamentoRepository;

    public List<Departamento> listarDepartamentos (){
        return departamentoRepository.findAll();
    }

    public Departamento criarDepartamento(CriarDepartamentoDTO departamento){
        Departamento novoDepartamento = new Departamento(departamento);
        return departamentoRepository.save(novoDepartamento);
    }

    public Departamento atualizarDepartamento (AtualizarDepartamentoDTO departamento){
        Departamento buscarDepartamento = departamentoRepository.findById(departamento.idDepartamento()).orElseThrow(()-> new RuntimeException("DepartamentoController não localizado pelo ID informado"));
        if (departamento.nome() != null){
            buscarDepartamento.setNomeDepartamento(departamento.nome());
        }
        return departamentoRepository.save(buscarDepartamento);
    }

    public void deletarDepartamento (Long idDepartamento){
        departamentoRepository.deleteById(idDepartamento);
    }
}
