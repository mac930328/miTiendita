package com.mac.tiendita.servicios;

import com.mac.tiendita.modelos.Producto;
import com.mac.tiendita.respositorios.ProductoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductoServicio {

    @Autowired
    private ProductoRepositorio repositorio;

    public List<Producto> obtenerTodos() {
        return repositorio.obtenerTodos();
    }

    public Optional<Producto> obtenerPorId(Integer id) {
        return repositorio.obtenerPorId(id);
    }

    public Producto guardar(Producto producto) {
        if (producto.getCodigo() == null) {
            return repositorio.guardarActualizar(producto);
        } else {
            Optional<Producto> c = repositorio.obtenerPorId(producto.getCodigo());
            if (c.isEmpty()) {
                return repositorio.guardarActualizar(producto);
            } else {
                return producto;
            }
        }
    }

    public Producto actualizar(Producto producto) {
        if (producto.getCodigo() != null) {
            Optional<Producto> c = repositorio.obtenerPorId(producto.getCodigo());
            if (!c.isEmpty()) {
                return repositorio.guardarActualizar(producto);
            } else {
                return producto;
            }
        } else {
            return producto;
        }
    }

    public boolean eliminar(Integer id) {
        return obtenerPorId(id).map(producto -> {
            repositorio.eliminar(producto.getCodigo());
            return true;
        }).orElse(false);
    }
}
