package com.projeto_aws.Inventarioti.domain;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "Status")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "idStatus")
public class Status {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idStatus;
    @Column(length = 20)
    private String valorStatus;


}
