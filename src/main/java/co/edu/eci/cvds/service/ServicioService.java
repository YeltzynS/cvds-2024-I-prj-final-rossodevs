package co.edu.eci.cvds.service;

import co.edu.eci.cvds.model.Servicio;
import co.edu.eci.cvds.repository.ServicioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServicioService {

    @Autowired
    private ServicioRepository servicioRepository;

    public List<Servicio> getAllServicios() {
        return servicioRepository.findAll();
    }

    public ResponseEntity<Servicio> getServicioById(Long id) {
        Optional<Servicio> servicio = servicioRepository.findById(id);
        if (servicio.isPresent()) {
            return ResponseEntity.ok(servicio.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    public Servicio createServicio(Servicio servicio) {
        return servicioRepository.save(servicio);
    }

    public ResponseEntity<Servicio> updateServicio(Long id, Servicio servicio) {
        if (servicioRepository.existsById(id)) {
            servicio.setId(id);
            return ResponseEntity.ok(servicioRepository.save(servicio));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    public void deleteServicio(Long id) {
        servicioRepository.deleteById(id);
    }
}
