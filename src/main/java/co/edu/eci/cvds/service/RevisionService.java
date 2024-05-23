package co.edu.eci.cvds.service;

import co.edu.eci.cvds.model.Revision;
import co.edu.eci.cvds.repository.RevisionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RevisionService {

    @Autowired
    private RevisionRepository revisionRepository;

    public List<Revision> getAllRevisiones() {
        return revisionRepository.findAll();
    }

    public ResponseEntity<Revision> getRevisionById(Long id) {
        Optional<Revision> revision = revisionRepository.findById(id);
        if (revision.isPresent()) {
            return ResponseEntity.ok(revision.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    public Revision createRevision(Revision revision) {
        return revisionRepository.save(revision);
    }

    public ResponseEntity<Revision> updateRevision(Long id, Revision revision) {
        if (revisionRepository.existsById(id)) {
            revision.setId(id);
            return ResponseEntity.ok(revisionRepository.save(revision));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    public void deleteRevision(Long id) {
        revisionRepository.deleteById(id);
    }
}
