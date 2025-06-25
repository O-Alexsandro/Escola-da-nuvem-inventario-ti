package com.projeto_aws.Inventarioti.domain.maquina;

import com.projeto_aws.Inventarioti.dto.maquinaDTO.CriarMaquinaDTO;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "maquinas")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "idMaquina")
public class Maquina {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idMaquina;

    @Column(length = 100)
    private String placaMae;

    @Enumerated(EnumType.STRING)
    @Column(length = 5)
    private MarcaProcessador marcaProcessador;

    @Column(length = 100)
    private String processador;

    @Enumerated(EnumType.STRING)
    @Column(length = 4)
    private ModeloMemoria modeloMemoria;

    @Column(length = 6)
    private FrequenciaMemoria frequenciaMemoria;

    private Long quantidadeMemoria;

    @Enumerated(EnumType.STRING)
    @Column(length = 4)
    private TipoArmazenamento tipoArmazenamento;

    private Long quantidadeArmazenamento;

    public Maquina(CriarMaquinaDTO maquina) {
        this.placaMae = maquina.placaMae();
        this.marcaProcessador = maquina.marcaProcessador();
        this.processador = maquina.processador();
        this.modeloMemoria = maquina.modeloMemoria();
        this.frequenciaMemoria = maquina.frequenciaMemoria();
        this.quantidadeMemoria = maquina.quantidadeMemoria();
        this.tipoArmazenamento = maquina.tipoArmazenamento();
        this.quantidadeArmazenamento = maquina.quantidadeArmazenamento();
    }
}
