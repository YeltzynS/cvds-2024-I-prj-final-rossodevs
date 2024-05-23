package co.edu.eci.cvds.repository;

import co.edu.eci.cvds.model.Revision;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RevisionRepository extends JpaRepository<Revision, Long> {
}
