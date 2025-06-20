package com.projeto_aws.Inventarioti.service;

import com.projeto_aws.Inventarioti.domain.Software;
import com.projeto_aws.Inventarioti.dto.softwareDTO.AtualizarSoftwareDTO;
import com.projeto_aws.Inventarioti.dto.softwareDTO.CriarSoftwareDTO;
import com.projeto_aws.Inventarioti.repository.SoftwareRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SoftwareService {

    @Autowired
    private SoftwareRepository softwareRepository;

    public List<Software> listarSoftwares(){
        return softwareRepository.findAll();
    }

    public Software criarSoftware(CriarSoftwareDTO software){
        Software novoSoftware = new Software(software);
        return softwareRepository.save(novoSoftware);
    }

    public Software atualizarSoftware(AtualizarSoftwareDTO software){
        Software atualizaSoftware = softwareRepository.findById(software.idSoftware()).orElseThrow(()-> new EntityNotFoundException("Software não encontrado com o id informado"));

        if (software.nome() != null){
            atualizaSoftware.setNomeSuprimento(software.nome());
        }

        if (software.descricao() != null){
            atualizaSoftware.setDescricaoSuprimento(software.descricao());
        }

        return softwareRepository.save(atualizaSoftware);
    }

    public void deletaSoftware(Long idSoftware){
        Software busca = softwareRepository.findById(idSoftware).orElseThrow(()-> new EntityNotFoundException("Software não encontrado com o id informado"));
        softwareRepository.delete(busca);
    }
}
