package com.projeto_aws.Inventarioti.service;

import com.projeto_aws.Inventarioti.domain.frequenciaMemoria.FrequenciaMemoria;
import com.projeto_aws.Inventarioti.domain.maquina.Maquina;
import com.projeto_aws.Inventarioti.domain.modeloMemoria.ModeloMemoria;
import com.projeto_aws.Inventarioti.domain.modeloMemoria.TipoModeloMemoria;
import com.projeto_aws.Inventarioti.domain.unidadeArmazenamento.UnidadeArmazenamento;
import com.projeto_aws.Inventarioti.dto.maquinaDTO.AtualizarMaquinaDTO;
import com.projeto_aws.Inventarioti.dto.maquinaDTO.CriarMaquinaDTO;
import com.projeto_aws.Inventarioti.repository.FrequenciaMemoriaRepository;
import com.projeto_aws.Inventarioti.repository.MaquinaRepository;
import com.projeto_aws.Inventarioti.repository.ModeloMemoriaRepository;
import com.projeto_aws.Inventarioti.repository.UnidadeArmazenamentoRepositoy;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MaquinaService {

    @Autowired
    private MaquinaRepository maquinaRepository;

    @Autowired
    private ModeloMemoriaRepository modeloMemoriaRepository;

    @Autowired
    private FrequenciaMemoriaRepository frequenciaMemoriaRepository;

    @Autowired
    private UnidadeArmazenamentoRepositoy unidadeArmazenamentoRepositoy;

    public List<Maquina> listarMaquinas(){
        return maquinaRepository.findAll();
    }

    public Maquina listarMaquinaPorId(Long idMaquina){
        return maquinaRepository.findById(idMaquina).orElseThrow(()-> new EntityNotFoundException("Máquina não encontrada com o ID informado"));
    }

    public Maquina criarMaquina(CriarMaquinaDTO maquina){
        Maquina novaMaquina = new Maquina(maquina);
        return maquinaRepository.save(novaMaquina);
    }

    public Maquina atualizarMaquina(AtualizarMaquinaDTO maquina){
        Maquina atualizaMaquina = maquinaRepository.findById(maquina.id()).orElseThrow(()-> new EntityNotFoundException("Máquina não encontrada com o ID informado"));

        if (maquina.placaMae() != null){
            atualizaMaquina.setPlacaMae(maquina.placaMae());
        }

        if (maquina.processador() != null){
            atualizaMaquina.setProcessador(maquina.processador());
        }

        if (maquina.modeloMemoria() != null){
            ModeloMemoria modeloMemoria = modeloMemoriaRepository.findByModeloMemoria(maquina.modeloMemoria());
            atualizaMaquina.setModeloMemoria(modeloMemoria);
        }

        if (maquina.frequenciaMemoria() != null){
            FrequenciaMemoria frequenciaMemoria = frequenciaMemoriaRepository.findByFrequenciaMemoria(maquina.frequenciaMemoria());
            atualizaMaquina.setFrequenciaMemoria(frequenciaMemoria);
        }

        if (maquina.quantidadeMemoria() != null){
            atualizaMaquina.setQuantidadeMemoria(maquina.quantidadeMemoria());
        }

        if (maquina.tipoArmazenamento() != null){
            UnidadeArmazenamento tipoArmazenamento = unidadeArmazenamentoRepositoy.findByTipoArmazenamento(maquina.tipoArmazenamento());
            atualizaMaquina.setTipoArmazenamento(tipoArmazenamento);
        }

        if (maquina.quantidadeArmazenamento()!= null){
            atualizaMaquina.setQuantidadeArmazenamento(maquina.quantidadeArmazenamento());
        }
        return maquinaRepository.save(atualizaMaquina);
    }

    public void deletarMaquina(Long idMaquina){
        Maquina buscaMaquina = maquinaRepository.findById(idMaquina).orElseThrow(()-> new EntityNotFoundException("Máquina não encontrada com o ID informado"));
        maquinaRepository.delete(buscaMaquina);
    }

    public Long quantidadeMaquinas(){
        return maquinaRepository.count();
    }

}
