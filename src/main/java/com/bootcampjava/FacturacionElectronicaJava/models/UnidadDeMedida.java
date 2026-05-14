package com.bootcampjava.FacturacionElectronicaJava.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "unidades_de_medida")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UnidadDeMedida {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @Column(name = "cod_unidad", nullable = false)
    private int codUnidad; //no nulo

    @Column(name = "desc_unidad", nullable = false)
    private String descUnidad; //no nulo
}
