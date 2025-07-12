package com.projeto_aws.Inventarioti.domain.maquina;

import com.projeto_aws.Inventarioti.domain.frequenciaMemoria.FrequenciaMemoria;
import com.projeto_aws.Inventarioti.domain.marcaProcessador.MarcaProcessador;
import com.projeto_aws.Inventarioti.domain.modeloMemoria.ModeloMemoria;
import com.projeto_aws.Inventarioti.domain.unidadeArmazenamento.UnidadeArmazenamento;
import com.projeto_aws.Inventarioti.dto.maquinaDTO.CriarMaquinaDTO;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "maquina")
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
    @ManyToOne
    @JoinColumn(name = "idMarcaProcessador", nullable = false)
    private MarcaProcessador marcaProcessador;

    @Column(length = 100)
    private String processador;

    @Enumerated(EnumType.STRING)
    @ManyToOne
    @JoinColumn(name = "idModeloMemoria", nullable = false)
    private ModeloMemoria modeloMemoria;

    @Enumerated(EnumType.STRING)
    @ManyToOne
    @JoinColumn(name = "idFrequenciaMemoria", nullable = false)
    private FrequenciaMemoria frequenciaMemoria;

    private Long quantidadeMemoria;

    @Enumerated(EnumType.STRING)
    @ManyToOne
    @JoinColumn(name = "idTipoArmazenamento", nullable = false)
    private UnidadeArmazenamento tipoArmazenamento;

    private Long quantidadeArmazenamento;

    private LocalDateTime dataCadastro;

    public Maquina(CriarMaquinaDTO maquina) {
        this.placaMae = maquina.placaMae();
        this.marcaProcessador = new MarcaProcessador();
        marcaProcessador.setNomeMarcaProcessador(maquina.marcaProcessador());
        this.processador = maquina.processador();

        this.modeloMemoria = new ModeloMemoria();
        modeloMemoria.setModeloMemoria(maquina.modeloMemoria());

        this.frequenciaMemoria = new FrequenciaMemoria();
        frequenciaMemoria.setFrequenciaMemoria(maquina.frequenciaMemoria());
        this.quantidadeMemoria = maquina.quantidadeMemoria();
        this.tipoArmazenamento = new UnidadeArmazenamento();
        tipoArmazenamento.setTipoArmazenamento(maquina.tipoArmazenamento());
        this.quantidadeArmazenamento = maquina.quantidadeArmazenamento();
        this.dataCadastro = LocalDateTime.now();
    }
}
