package com.mac.tiendita.respositorios;

import com.mac.tiendita.modelos.Producto;
import com.mac.tiendita.respositorios.crud.ProductoInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ProductoRepositorio {

    @Autowired
    private ProductoInterface crud;

    public List<Producto> obtenerTodos() {
        return (List<Producto>) crud.findAll();
    }

    public Optional<Producto> obtenerPorId(Integer codigo) {
        return crud.findById(codigo);
    }

    public Producto guardarActualizar(Producto producto) {
        return crud.save(producto);
    }

    public void eliminar(Integer codigo) {
        crud.deleteById(codigo);
    }
}
