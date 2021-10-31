package com.mac.tiendita.respositorios;

import com.mac.tiendita.modelos.Cliente;
import com.mac.tiendita.respositorios.crud.ClienteInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ClienteRepositorio {

    @Autowired
    private ClienteInterface crud;

    public List<Cliente> obtenerTodos() {
        return (List<Cliente>) crud.findAll();
    }

    public Optional<Cliente> obtenerPorId(Long cedula) {
        return crud.findById(cedula);
    }

    public Cliente guardarActualizar(Cliente cliente) {
        return crud.save(cliente);
    }

    public void eliminar(Long cedula) {
        crud.deleteById(cedula);
    }
}
