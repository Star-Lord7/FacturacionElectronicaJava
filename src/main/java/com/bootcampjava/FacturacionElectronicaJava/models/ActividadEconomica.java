package com.bootcampjava.FacturacionElectronicaJava.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "actividades_economicas")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ActividadEconomica {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @Column(name = "cod_actividad", nullable = false)
    private String codActividad; // no nulo

    @Column(name = "desc_actividad", nullable = false)
    private String descActividad; // no nulo
}
