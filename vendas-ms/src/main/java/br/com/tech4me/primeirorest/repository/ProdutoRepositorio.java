package br.com.tech4me.primeirorest.repository;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import br.com.tech4me.primeirorest.compartilhado.Produto;



public interface ProdutoRepositorio extends MongoRepository<Produto, String> {
    @Query(value="{'id' : ?0}")
    List<Produto> procurarId(String id);

    
}
