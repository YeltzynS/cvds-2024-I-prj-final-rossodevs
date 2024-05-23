package co.edu.eci.cvds.service;

import co.edu.eci.cvds.model.Cliente;
import co.edu.eci.cvds.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public List<Cliente> getAllClientes() {
        return clienteRepository.findAll();
    }

    public ResponseEntity<Cliente> getClienteById(Long id) {
        Optional<Cliente> cliente = clienteRepository.findById(id);
        if (cliente.isPresent()) {
            return ResponseEntity.ok(cliente.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    public Cliente createCliente(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    public ResponseEntity<Cliente> updateCliente(Long id, Cliente cliente) {
        if (clienteRepository.existsById(id)) {
            cliente.setId(id);
            return ResponseEntity.ok(clienteRepository.save(cliente));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    public void deleteCliente(Long id) {
        clienteRepository.deleteById(id);
    }
}
