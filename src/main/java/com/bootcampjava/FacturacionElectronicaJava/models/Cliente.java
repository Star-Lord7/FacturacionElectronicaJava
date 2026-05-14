package com.bootcampjava.FacturacionElectronicaJava.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "clientes")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Cliente{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @Column(name = "tipo_documento", nullable = false)
    private int tipoDocumento; //13 DUI, 36 NIT, 37 OTRO

    @Column(name = "num_documento", nullable = false)
    private String numDocumento; //sin guiones

    @Column(name = "nrc", nullable = false)
    private String nrc; //sin guiones

    @Column(name = "nombre", nullable = false)
    private String nombre;

    @Column(name = "nombre_comercial", nullable = false)
    private String nombreComercial;

    @Column(name = "telefono", nullable = false)
    private String telefono;

    @Column(name = "correo", nullable = false)
    private String correo;

    @Column(name = "gran_contribuyente", nullable = false)
    private boolean granContribuyente;

    //@JsonIgnore
    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "municipio_id", nullable = false)
    private Municipio municipio;

    /*@Column(name = "direccion", nullable = false)
    private Direccion direccion;*/
}

/*
* A considerar despues
*
    public Object codActividad;
    public Object descActividad;
*
* */
