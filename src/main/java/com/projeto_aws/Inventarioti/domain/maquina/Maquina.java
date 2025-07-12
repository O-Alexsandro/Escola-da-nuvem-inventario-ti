package com.projeto_aws.Inventarioti.domain.maquina;

import com.projeto_aws.Inventarioti.domain.frequenciaMemoria.FrequenciaMemoria;
import com.projeto_aws.Inventarioti.domain.marcaProcessador.MarcaProcessador;
import com.projeto_aws.Inventarioti.domain.modeloMemoria.ModeloMemoria;
import com.projeto_aws.Inventarioti.domain.unidadeArmazenamento.UnidadeArmazenamento;
import com.projeto_aws.Inventarioti.dto.maquinaDTO.CriarMaquinaDTO;
//import com.projeto_aws.Inventarioti.utils.FrequenciaMemoriaConverter;
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

    @ManyToOne
    @JoinColumn(name = "idMarcaProcessador", nullable = false)
    private MarcaProcessador marcaProcessador;

    @Column(length = 100)
    private String processador;

    @ManyToOne
    @JoinColumn(name = "idModeloMemoria", nullable = false)
    private ModeloMemoria modeloMemoria;

    @ManyToOne
    @JoinColumn(name = "idFrequenciaMemoria", nullable = false)
    private FrequenciaMemoria frequenciaMemoria;

    private Long quantidadeMemoria;

    @ManyToOne
    @JoinColumn(name = "idTipoArmazenamento", nullable = false)
    private UnidadeArmazenamento tipoArmazenamento;

    private Long quantidadeArmazenamento;

    private LocalDateTime dataCadastro;

}
