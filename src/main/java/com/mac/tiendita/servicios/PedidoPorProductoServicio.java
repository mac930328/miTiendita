package com.mac.tiendita.servicios;

import com.mac.tiendita.modelos.PedidoPorProducto;
import com.mac.tiendita.respositorios.PedidoPorProductoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PedidoPorProductoServicio {

    @Autowired
    private PedidoPorProductoRepositorio repositorio;

    public List<PedidoPorProducto> obtenerTodos() {
        return repositorio.obtenerTodos();
    }

    public Optional<PedidoPorProducto> obtenerPorId(Integer id) {
        return repositorio.obtenerPorId(id);
    }

    public PedidoPorProducto guardar(PedidoPorProducto pedidoPorProducto) {
        if (pedidoPorProducto.getId() == null) {
            return repositorio.guardarActualizar(pedidoPorProducto);
        } else {
            Optional<PedidoPorProducto> c = repositorio.obtenerPorId(pedidoPorProducto.getId());
            if (c.isEmpty()) {
                return repositorio.guardarActualizar(pedidoPorProducto);
            } else {
                return pedidoPorProducto;
            }
        }
    }

    public PedidoPorProducto actualizar(PedidoPorProducto pedidoPorProducto) {
        if (pedidoPorProducto.getId() != null) {
            Optional<PedidoPorProducto> c = repositorio.obtenerPorId(pedidoPorProducto.getId());
            if (!c.isEmpty()) {
                return repositorio.guardarActualizar(pedidoPorProducto);
            } else {
                return pedidoPorProducto;
            }
        } else {
            return pedidoPorProducto;
        }
    }

    public boolean eliminar(Integer id) {
        return obtenerPorId(id).map(pedidoPorProducto -> {
            repositorio.eliminar(pedidoPorProducto.getId());
            return true;
        }).orElse(false);
    }
}
