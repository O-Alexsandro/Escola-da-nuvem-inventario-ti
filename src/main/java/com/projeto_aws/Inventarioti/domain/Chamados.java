package com.projeto_aws.Inventarioti.domain;

import com.projeto_aws.Inventarioti.domain.usuarioSistema.UsuarioSistema;
import com.projeto_aws.Inventarioti.dto.chamadosDTO.RegistrarChamadoDTO;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDateTime;

@Entity
@Table(name = "Chamados")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "idChamado")
public class Chamados {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idChamado;

    @Column(length = 100)
    private String tituloChamado;
    private String descricao;

    @ManyToOne
    @JoinColumn(name = "idPrioridade")
    private Prioridade prioridade;

    @ManyToOne
    @JoinColumn(name = "idDepartamento")
    private Departamento departamento;

    @Column(columnDefinition = "BYTEA")
    private byte[] anexo;

    private LocalDateTime dataCadastro;

    @ManyToOne
    @JoinColumn(name = "idStatus")
    private Status status;

    @OneToOne
    @JoinColumn(name = "idUsuarioSistema")
    private UsuarioSistema usuarioSistema;

    public Chamados(RegistrarChamadoDTO registrarChamadoDTO, MultipartFile anexo) throws IOException {
        this.tituloChamado = registrarChamadoDTO.tituloChamado();
        this.descricao = registrarChamadoDTO.descricao();

        this.prioridade = new Prioridade();
        prioridade.setIdPrioridade(registrarChamadoDTO.IdPrioridade());

        this.departamento = new Departamento();
        departamento.setIdDepartamento(registrarChamadoDTO.IdDepartamento());

        this.anexo = anexo.getBytes();

        this.dataCadastro = LocalDateTime.now();

        this.status = new Status();
        status.setIdStatus(registrarChamadoDTO.IdStatus());
    }

    public Chamados(RegistrarChamadoDTO registrarChamadoDTO) {
        this.tituloChamado = registrarChamadoDTO.tituloChamado();
        this.descricao = registrarChamadoDTO.descricao();

        this.prioridade = new Prioridade();
        prioridade.setIdPrioridade(registrarChamadoDTO.IdPrioridade());

        this.departamento = new Departamento();
        departamento.setIdDepartamento(registrarChamadoDTO.IdDepartamento());
        this.dataCadastro = LocalDateTime.now();

        this.status = new Status();
        status.setIdStatus(registrarChamadoDTO.IdStatus());
    }
}
