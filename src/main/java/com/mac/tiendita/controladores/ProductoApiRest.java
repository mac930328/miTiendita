package com.mac.tiendita.controladores;

import com.mac.tiendita.modelos.Producto;
import com.mac.tiendita.servicios.ProductoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/Producto")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})

public class ProductoApiRest {

    @Autowired
    private ProductoServicio servicio;

    @GetMapping("/all")
    public List<Producto> obtenerTodos() {
        return servicio.obtenerTodos();
    }

    @GetMapping("/{id}")
    public Optional<Producto> obtenerPorId(@PathVariable("id") Integer id) {
        return servicio.obtenerPorId(id);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Producto guardar(@RequestBody Producto producto) {
        return servicio.guardar(producto);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Producto actualizar(@RequestBody Producto producto) {
        return servicio.actualizar(producto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean eliminar(@PathVariable("id") Integer id) {
        return servicio.eliminar(id);
    }
}
