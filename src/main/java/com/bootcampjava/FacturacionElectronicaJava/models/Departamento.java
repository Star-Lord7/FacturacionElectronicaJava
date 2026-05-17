package com.bootcampjava.FacturacionElectronicaJava.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "departamentos")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Departamento {

    //Las propiedades se usan por medio de getter y setter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @Column(name = "codigo", nullable = false)
    private String Codigo;

    @Column(name = "nombre", nullable = false)
    private String Nombre;

    // @JsonIgnore //Evita recursividad
    @OneToMany(mappedBy = "departamento", cascade = CascadeType.ALL, orphanRemoval = false)
    private List<Municipio> municipios = new ArrayList<>();

    //public void setId(Long id) {}
}
