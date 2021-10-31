package com.mac.tiendita.servicios;

import com.mac.tiendita.modelos.Cliente;
import com.mac.tiendita.respositorios.ClienteRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteServicio {

    @Autowired
    private ClienteRepositorio repositorio;

    public List<Cliente> obtenerTodos() {
        return repositorio.obtenerTodos();
    }

    public Optional<Cliente> obtenerPorId(Long id) {
        return repositorio.obtenerPorId(id);
    }

    public Cliente guardar(Cliente cliente) {
        if (cliente.getCedula() == null) {
            return repositorio.guardarActualizar(cliente);
        } else {
            Optional<Cliente> c = repositorio.obtenerPorId(cliente.getCedula());
            if (c.isEmpty()) {
                return repositorio.guardarActualizar(cliente);
            } else {
                return cliente;
            }
        }
    }

    public Cliente actualizar(Cliente cliente) {
        if (cliente.getCedula() != null) {
            Optional<Cliente> c = repositorio.obtenerPorId(cliente.getCedula());
            if (!c.isEmpty()) {
                return repositorio.guardarActualizar(cliente);
            } else {
                return cliente;
            }
        } else {
            return cliente;
        }
    }

    public boolean eliminar(Long cedula) {
        return obtenerPorId(cedula).map(cliente -> {
            repositorio.eliminar(cliente.getCedula());
            return true;
        }).orElse(false);
    }
}
