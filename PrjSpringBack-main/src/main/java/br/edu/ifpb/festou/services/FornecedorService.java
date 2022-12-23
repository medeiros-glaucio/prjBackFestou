package br.edu.ifpb.festou.services;

import br.edu.ifpb.festou.models.Fornecedor;
import br.edu.ifpb.festou.repositories.FornecedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
public class FornecedorService {
    @Autowired
    private FornecedorRepository fornecedorRepository;

    public Fornecedor getFornecedor(Long id) throws RuntimeException {
        return fornecedorRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Fornecedor not found with id: " + id)
        );
    }

    @Transactional
    public Fornecedor create(Fornecedor fornecedor) {
        return fornecedorRepository.save(fornecedor);
    }

    @Transactional
    public Fornecedor update(Long id, Fornecedor fornecedor) {
        Fornecedor fornecedorToUpdate = this.getFornecedor(id);

        if (fornecedor.getNome() != null)
            fornecedorToUpdate.setNome(fornecedor.getNome());
        if (fornecedor.getTelefone() != null)
            fornecedorToUpdate.setTelefone(fornecedor.getTelefone());

        if (fornecedor.getDescricao() != null)
            fornecedorToUpdate.setDescricao(fornecedor.getDescricao());
        if (fornecedor.getPreco() != null)
            fornecedorToUpdate.setPreco(fornecedor.getPreco());

        return fornecedorRepository.save(fornecedorToUpdate);
    }

    @Transactional
    public void delete(Long id) {
        fornecedorRepository.deleteById(id);
    }

    public List<Fornecedor> listar(){
        return fornecedorRepository.findAll();
    }

}

