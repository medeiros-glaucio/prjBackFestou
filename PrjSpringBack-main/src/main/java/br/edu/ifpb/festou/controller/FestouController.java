package br.edu.ifpb.festou.controller;

import br.edu.ifpb.festou.models.Cliente;
import br.edu.ifpb.festou.models.Fornecedor;
import br.edu.ifpb.festou.services.ClienteService;
import br.edu.ifpb.festou.services.FornecedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/festou")
public class FestouController {
    @Autowired
    private ClienteService clienteService;

    @GetMapping("/{id}")
    public Cliente get(@PathVariable("id") Long id) {
        return clienteService.getCliente(id);
    }

    @PostMapping
    public Cliente create(@RequestBody Cliente Cliente) {
        return clienteService.create(Cliente);
    }

    @PutMapping("/{id}")
    public Cliente update(@PathVariable("id") Long id, @RequestBody Cliente Cliente) {
        return clienteService.update(id, Cliente);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) {
        clienteService.delete(id);
    }

    @GetMapping
    public List<Cliente> listar(){
        return clienteService.listar();
    }

}