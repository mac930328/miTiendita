package com.mac.tiendita.respositorios.crud;

import com.mac.tiendita.modelos.Pedido;
import com.mac.tiendita.modelos.Producto;
import org.springframework.data.repository.CrudRepository;

public interface PedidoInterface extends CrudRepository<Pedido,Integer> {
}
