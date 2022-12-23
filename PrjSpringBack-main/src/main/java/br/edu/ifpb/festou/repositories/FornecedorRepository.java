package br.edu.ifpb.festou.repositories;

import br.edu.ifpb.festou.models.Fornecedor;
import org.springframework.data.jpa.repository.JpaRepository;


public interface FornecedorRepository extends JpaRepository<Fornecedor, Long>{
    public Fornecedor findByNome(String nome);
    public Fornecedor findByTelefone(String telefone);
}