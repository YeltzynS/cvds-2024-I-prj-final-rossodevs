package co.edu.eci.cvds.controller;

import co.edu.eci.cvds.model.Revision;
import co.edu.eci.cvds.service.RevisionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/revisiones")
public class RevisionController {

    @Autowired
    private RevisionService revisionService;

    @GetMapping
    public List<Revision> getAllRevisiones() {
        return revisionService.getAllRevisiones();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Revision> getRevisionById(@PathVariable Long id) {
        return revisionService.getRevisionById(id);
    }

    @PostMapping
    public Revision createRevision(@RequestBody Revision revision) {
        return revisionService.createRevision(revision);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Revision> updateRevision(@PathVariable Long id, @RequestBody Revision revision) {
        return revisionService.updateRevision(id, revision);
    }

    @DeleteMapping("/{id}")
    public void deleteRevision(@PathVariable Long id) {
        revisionService.deleteRevision(id);
    }
}
