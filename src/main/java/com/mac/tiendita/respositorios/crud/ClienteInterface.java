package com.mac.tiendita.respositorios.crud;

import com.mac.tiendita.modelos.Cliente;
import org.springframework.data.repository.CrudRepository;

public interface ClienteInterface extends CrudRepository<Cliente, Long> {
}
