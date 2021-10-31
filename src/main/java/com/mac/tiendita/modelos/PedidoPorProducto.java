package com.mac.tiendita.modelos;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "pedido_por_producto")
public class PedidoPorProducto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer cantidad;
    @ManyToOne
    @JoinColumn(name = "pedido_orden")
    private Pedido pedido;
    @ManyToOne
    @JoinColumn(name = "producto_codigo")
    private Producto producto;

}
