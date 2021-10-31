package com.mac.tiendita.respositorios.crud;

import com.mac.tiendita.modelos.Producto;
import org.springframework.data.repository.CrudRepository;

public interface ProductoInterface extends CrudRepository<Producto,Integer> {
}
