package com.mac.tiendita.modelos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Data
@Entity
@Table(name = "cliente")
public class Cliente implements Serializable {

    @Id
    private Long cedula;
    private String nombre;
    private String apellido;
    private Long celular;
    private String correo;
    private String direccion;

    @OneToMany(mappedBy = "cliente", cascade = CascadeType.PERSIST)
    @JsonIgnoreProperties("cliente")
    private List<Pedido> pedidos;
}
