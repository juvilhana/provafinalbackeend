package br.com.tech4me.primeirorest.repository;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import br.com.tech4me.primeirorest.model.Venda;

@Repository
public interface VendaRepository extends MongoRepository<Venda, String> {

    
}
