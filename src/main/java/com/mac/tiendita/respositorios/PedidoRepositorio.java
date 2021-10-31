package com.mac.tiendita.respositorios;

import com.mac.tiendita.modelos.Pedido;
import com.mac.tiendita.respositorios.crud.PedidoInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class PedidoRepositorio {

    @Autowired
    private PedidoInterface crud;

    public List<Pedido> obtenerTodos() {
        return (List<Pedido>) crud.findAll();
    }

    public Optional<Pedido> obtenerPorId(Integer orden) {
        return crud.findById(orden);
    }

    public Pedido guardarActualizar(Pedido pedido) {
        return crud.save(pedido);
    }

    public void eliminar(Integer orden) {
        crud.deleteById(orden);
    }
}
