package co.edu.eci.cvds.repository;

import co.edu.eci.cvds.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
