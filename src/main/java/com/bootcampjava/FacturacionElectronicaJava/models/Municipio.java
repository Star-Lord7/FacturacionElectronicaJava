package com.bootcampjava.FacturacionElectronicaJava.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "municipios")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Municipio {

    //Las propiedades se usan por medio de getter y setter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @Column(name = "codigo", nullable = false)
    private String Codigo;

    @Column(name = "nombre", nullable = false)
    private String Nombre;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "departamento_id", nullable = false)
    private Departamento departamento;

    //@JsonIgnore //Evita recursividad
    @JsonManagedReference
    @OneToMany(mappedBy = "municipio", cascade = CascadeType.ALL, orphanRemoval = false)
    private List<Cliente> clientes = new ArrayList<>();

    //@JsonIgnore //Evita recursividad
    @JsonManagedReference
    @OneToMany(mappedBy = "municipio", cascade = CascadeType.ALL, orphanRemoval = false)
    private List<Comercio> comercios = new ArrayList<>();

}
