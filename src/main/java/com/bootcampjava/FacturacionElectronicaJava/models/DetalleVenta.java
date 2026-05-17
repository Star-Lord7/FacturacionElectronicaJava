package com.bootcampjava.FacturacionElectronicaJava.models;

import com.bootcampjava.FacturacionElectronicaJava.enums.TipoBien;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Entity
@Table(name = "detallesVenta")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DetalleVenta{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @Column(name = "numItem", nullable = false)
    public int numItem;

    @Enumerated(EnumType.ORDINAL)
    @Column(name = "tipoItem", nullable = false)
    public TipoBien tipoItem; // 1 2 3 hacer un enum

    @Column(name = "numeroDocumento", nullable = true)
    public String numeroDocumento;

    @Column(name = "cantidad", nullable = false, precision = 18, scale = 4)
    public BigDecimal cantidad;

    @Column(name = "codigo", nullable = false)
    public String codigo;

    @Column(name = "codTributo", nullable = true)
    public String codTributo;

    @Column(name = "descripcion", nullable = false)
    public String descripcion;

    @Column(name = "precioUni", nullable = false, precision = 18, scale = 4)
    public BigDecimal precioUni;

    @Column(name = "montoDescu", nullable = false, precision = 18, scale = 4)
    public BigDecimal montoDescu;

    @Column(name = "ventaNoSuj", nullable = false, precision = 18, scale = 4)
    public BigDecimal ventaNoSuj;

    @Column(name = "ventaExenta", nullable = false, precision = 18, scale = 4)
    public BigDecimal ventaExenta;

    @Column(name = "ventaGravada", nullable = false, precision = 18, scale = 4)
    public BigDecimal ventaGravada;

    //  public Object tributos; array

    @Column(name = "psv", nullable = false, precision = 18, scale = 4)
    public BigDecimal psv; //precio sugerido de venta

    @Column(name = "noGravado", nullable = true, precision = 18, scale = 4)
    public BigDecimal noGravado;

    @Column(name = "ivaItem", nullable = true, precision = 18, scale = 4)
    public BigDecimal ivaItem;

    //relaciones
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "producto_id", nullable = false)
    private Producto producto;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "venta_id", nullable = false)
    private Venta ventas;
}
