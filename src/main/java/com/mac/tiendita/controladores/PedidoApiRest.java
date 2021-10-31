package com.mac.tiendita.controladores;

import com.mac.tiendita.modelos.Cliente;
import com.mac.tiendita.modelos.Pedido;
import com.mac.tiendita.servicios.ClienteServicio;
import com.mac.tiendita.servicios.PedidoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/Pedido")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class PedidoApiRest {

    @Autowired
    private PedidoServicio servicio;

    @GetMapping("/all")
    public List<Pedido> obtenerTodos() {
        return servicio.obtenerTodos();
    }

    @GetMapping("/{id}")
    public Optional<Pedido> obtenerPorId(@PathVariable("id") Integer id) {
        return servicio.obtenerPorId(id);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Pedido guardar(@RequestBody Pedido pedido) {
        return servicio.guardar(pedido);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Pedido actualizar(@RequestBody Pedido pedido) {
        return servicio.actualizar(pedido);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean eliminar(@PathVariable("id") Integer id) {
        return servicio.eliminar(id);
    }
}
