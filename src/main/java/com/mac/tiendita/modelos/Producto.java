package com.mac.tiendita.modelos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Data
@Entity
@Table(name = "producto")
public class Producto implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer codigo;
    private String nombre;
    private Double precio;
    private Double inventario;

    @OneToMany(mappedBy = "producto", cascade = CascadeType.PERSIST)
    @JsonIgnoreProperties({"producto","pedido"})
    private List<PedidoPorProducto> pedidoPorProductos;
}
