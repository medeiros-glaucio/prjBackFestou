package br.edu.ifpb.festou.services;

import br.edu.ifpb.festou.models.Cliente;
import br.edu.ifpb.festou.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ClienteService {
    @Autowired
    private ClienteRepository clienteRepository;

    public Cliente getCliente(Long id) throws RuntimeException {
        return clienteRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Cliente not found with id: " + id)
        );
    }

    @Transactional
    public Cliente create(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    @Transactional
    public Cliente update(Long id, Cliente cliente) {
        Cliente clienteToUpdate = this.getCliente(id);

        if (cliente.getNome() != null)
            clienteToUpdate.setNome(cliente.getNome());
        if (cliente.getIdade() >= 18)
            clienteToUpdate.setIdade(cliente.getIdade());


        if (cliente.getEmail() != null)
            clienteToUpdate.setEmail(cliente.getEmail());
        if (cliente.getTelefone() != null)
            clienteToUpdate.setTelefone(cliente.getTelefone());
        return clienteRepository.save(clienteToUpdate);
    }

    @Transactional
    public void delete(Long id) {
        clienteRepository.deleteById(id);
    }

    public List<Cliente> listar(){
        return clienteRepository.findAll();
    }

}