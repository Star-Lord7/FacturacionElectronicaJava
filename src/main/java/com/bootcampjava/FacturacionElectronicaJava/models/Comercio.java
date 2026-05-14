package com.bootcampjava.FacturacionElectronicaJava.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "comercios")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Comercio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long Id;

    @Column(name = "nit", nullable = false)
    private String nit; //permitir 9 o 14 caracteres

    @Column(name = "nrc", nullable = false)
    private String nrc; // no  nulo

    @Column(name = "nombre", nullable = false)
    private String nombre; //no nulo

    @Column(name = "nombre_comercial", nullable = false)
    private String nombreComercial; //no nulo

    @Column(name = "tipo_establecimiento", nullable = false)
    private String tipoEstablecimiento; //2 casa matriz 1 sucursal

    @Column(name = "telefono", nullable = false)
    private String telefono; //sin giones 8 caracteres

    @Column(name = "cod_estable_mh", nullable = false)
    private String codEstableMH; // M001 / S00X codigo de sucursal

    @Column(name = "cod_estable", nullable = false)
    private String codEstable; //Lo mismo que EstableMH

    @Column(name = "cod_punto_venta_mh", nullable = false)
    private String codPuntoVentaMH; //P00X

    @Column(name = "cod_punto_venta", nullable = false)
    private String codPuntoVenta; //lo mismo que VentaMH

    @Column(name = "correo", nullable = false)
    private String correo;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "municipio_id", nullable = false)
    private Municipio municipio;

    /*@Column(name = "direccion", nullable = false)
    private Direccion direccion;*/
}

/*

    public String codActividad;
    public String descActividad;
* */