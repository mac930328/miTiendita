package com.mac.tiendita.respositorios;

import com.mac.tiendita.modelos.PedidoPorProducto;
import com.mac.tiendita.respositorios.crud.PedidoPorProductoInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class PedidoPorProductoRepositorio {

    @Autowired
    private PedidoPorProductoInterface crud;

    public List<PedidoPorProducto> obtenerTodos() {
        return (List<PedidoPorProducto>) crud.findAll();
    }

    public Optional<PedidoPorProducto> obtenerPorId(Integer id) {
        return crud.findById(id);
    }

    public PedidoPorProducto guardarActualizar(PedidoPorProducto pedidoPorProducto) {
        return crud.save(pedidoPorProducto);
    }

    public void eliminar(Integer id) {
        crud.deleteById(id);
    }
}
