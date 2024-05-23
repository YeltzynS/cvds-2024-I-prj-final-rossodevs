package co.edu.eci.cvds.repository;

import co.edu.eci.cvds.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface productoRepository extends JpaRepository<Producto, Long> {
}
