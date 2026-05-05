package com.eventos.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.eventos.proyecto.model.Pago;
import com.eventos.proyecto.services.PagoService;

import java.util.List;

@RestController
@RequestMapping("/api/pagos")
public class PagoController {

    @Autowired
    private PagoService pagoService;

    @GetMapping //listar pagos
    public List<Pago> listar() {
        return pagoService.listar();
    }

    @PostMapping //crear pago
    public Pago crear(@RequestBody Pago pago) {
        return pagoService.guardar(pago);
    }

    @GetMapping("/{id}") //obtener pago por id
    public Pago obtener(@PathVariable Long id) {
        return pagoService.obtener(id);
    }

    @DeleteMapping("/{id}") //eliminar pago
    public void eliminar(@PathVariable Long id) {
        pagoService.eliminar(id);
    }

    @PutMapping("/{id}") //actualizar pago
    public Pago actualizar(@PathVariable Long id, @RequestBody Pago pagoActualizado) {
        Pago pago = pagoService.obtener(id);
        pago.setMonto(pagoActualizado.getMonto());
        pago.setFechaPago(pagoActualizado.getFechaPago());
        return pagoService.guardar(pago);
    }
}
