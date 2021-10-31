package com.mac.tiendita.servicios;

import com.mac.tiendita.modelos.Pedido;
import com.mac.tiendita.respositorios.PedidoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PedidoServicio {

    @Autowired
    private PedidoRepositorio repositorio;

    public List<Pedido> obtenerTodos() {
        return repositorio.obtenerTodos();
    }

    public Optional<Pedido> obtenerPorId(Integer id) {
        return repositorio.obtenerPorId(id);
    }

    public Pedido guardar(Pedido pedido) {
        if (pedido.getOrden() == null) {
            return repositorio.guardarActualizar(pedido);
        } else {
            Optional<Pedido> c = repositorio.obtenerPorId(pedido.getOrden());
            if (c.isEmpty()) {
                return repositorio.guardarActualizar(pedido);
            } else {
                return pedido;
            }
        }
    }

    public Pedido actualizar(Pedido pedido) {
        if (pedido.getOrden() != null) {
            Optional<Pedido> c = repositorio.obtenerPorId(pedido.getOrden());
            if (!c.isEmpty()) {
                return repositorio.guardarActualizar(pedido);
            } else {
                return pedido;
            }
        } else {
            return pedido;
        }
    }

    public boolean eliminar(Integer id) {
        return obtenerPorId(id).map(pedido -> {
            repositorio.eliminar(pedido.getOrden());
            return true;
        }).orElse(false);
    }
}
