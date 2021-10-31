package com.mac.tiendita.controladores;

import com.mac.tiendita.modelos.PedidoPorProducto;
import com.mac.tiendita.servicios.PedidoPorProductoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/PedidoPorProducto")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class PedidoPorProductoApiRest {

    @Autowired
    private PedidoPorProductoServicio servicio;

    @GetMapping("/all")
    public List<PedidoPorProducto> obtenerTodos() {
        return servicio.obtenerTodos();
    }

    @GetMapping("/{id}")
    public Optional<PedidoPorProducto> obtenerPorId(@PathVariable("id") Integer id) {
        return servicio.obtenerPorId(id);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public PedidoPorProducto guardar(@RequestBody PedidoPorProducto pedidoPorProducto) {
        return servicio.guardar(pedidoPorProducto);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public PedidoPorProducto actualizar(@RequestBody PedidoPorProducto pedidoPorProducto) {
        return servicio.actualizar(pedidoPorProducto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean eliminar(@PathVariable("id") Integer id) {
        return servicio.eliminar(id);
    }
}
