package com.mac.tiendita.respositorios.crud;

import com.mac.tiendita.modelos.PedidoPorProducto;
import com.mac.tiendita.modelos.Producto;
import org.springframework.data.repository.CrudRepository;

public interface PedidoPorProductoInterface extends CrudRepository<PedidoPorProducto,Integer> {
}
