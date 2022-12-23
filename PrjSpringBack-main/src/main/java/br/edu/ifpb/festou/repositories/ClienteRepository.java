package br.edu.ifpb.festou.repositories;

import br.edu.ifpb.festou.models.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ClienteRepository extends JpaRepository<Cliente, Long>{
    public Cliente findByNome(String nome);
    public Cliente findByTelefone(String telefone);
}