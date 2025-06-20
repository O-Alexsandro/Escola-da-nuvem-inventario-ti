package com.projeto_aws.Inventarioti.domain;

import com.projeto_aws.Inventarioti.dto.maquinaDTO.CriarMaquinaDTO;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "maquinas")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Maquina {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String placaMae;
    private String processador;
    private String modeloMemoria;
    private String frequenciaMemoria;
    private Long quantidadeMemoria;
    private String tipoArmazenamento;
    private Long quantidadeArmazenamento;

    public Maquina(CriarMaquinaDTO maquina) {
        this.placaMae = maquina.placaMae();
        this.processador = maquina.processador();
        this.modeloMemoria = maquina.modeloMemoria();
        this.frequenciaMemoria = maquina.frequenciaMemoria();
        this.quantidadeMemoria = maquina.quantidadeMemoria();
        this.tipoArmazenamento = maquina.tipoArmazenamento();
        this.quantidadeArmazenamento = maquina.quantidadeArmazenamento();
    }
}
