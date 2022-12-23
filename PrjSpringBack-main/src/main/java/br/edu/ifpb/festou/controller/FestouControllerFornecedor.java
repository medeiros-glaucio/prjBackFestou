package br.edu.ifpb.festou.controller;

import br.edu.ifpb.festou.models.Fornecedor;
import br.edu.ifpb.festou.services.FornecedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/festou2")
public class FestouControllerFornecedor {
    @Autowired
    private FornecedorService fornecedorService;

    @GetMapping("/{id}")
    public Fornecedor get(@PathVariable("id") Long id) {
        return fornecedorService.getFornecedor(id);
    }

    @PostMapping
    public Fornecedor create(@RequestBody Fornecedor Fornecedor) {
        return fornecedorService.create(Fornecedor);
    }

    @PutMapping("/{id}")
    public Fornecedor update(@PathVariable("id") Long id, @RequestBody Fornecedor Fornecedor) {
        return fornecedorService.update(id, Fornecedor);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) {
        fornecedorService.delete(id);
    }

    @GetMapping
    public List<Fornecedor> listar(){
        return fornecedorService.listar();
    }

}
