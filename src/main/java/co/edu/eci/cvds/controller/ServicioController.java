package co.edu.eci.cvds.controller;

import co.edu.eci.cvds.model.Servicio;
import co.edu.eci.cvds.service.ServicioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/servicios")
public class ServicioController {

    @Autowired
    private ServicioService servicioService;

    @GetMapping
    public List<Servicio> getAllServicios() {
        return servicioService.getAllServicios();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Servicio> getServicioById(@PathVariable Long id) {
        return servicioService.getServicioById(id);
    }

    @PostMapping
    public Servicio createServicio(@RequestBody Servicio servicio) {
        return servicioService.createServicio(servicio);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Servicio> updateServicio(@PathVariable Long id, @RequestBody Servicio servicio) {
        return servicioService.updateServicio(id, servicio);
    }

    @DeleteMapping("/{id}")
    public void deleteServicio(@PathVariable Long id) {
        servicioService.deleteServicio(id);
    }
}
