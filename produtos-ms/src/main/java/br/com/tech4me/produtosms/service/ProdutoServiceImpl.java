package br.com.tech4me.produtosms.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.tech4me.produtosms.compartilhado.ProdutoDto;
import br.com.tech4me.produtosms.model.Produto;
import br.com.tech4me.produtosms.repository.ProdutoRepositorio;

@Service
public class ProdutoServiceImpl implements ProdutoService {
    @Autowired
    private ProdutoRepositorio repo;

    @Override
    public List<ProdutoDto> obterTodos() {
        List<Produto> produtos = repo.findAll();

        return produtos.stream()
        .map(p -> new ModelMapper().map(p, ProdutoDto.class))
        .collect(Collectors.toList());
    }

    @Override
    public ProdutoDto criarProduto(ProdutoDto produtos) {
        ModelMapper mp = new ModelMapper();
        Produto pro = mp.map(produtos, Produto.class);
        pro = repo.save(pro);
        return mp.map(pro, ProdutoDto.class);
    }

    @Override
    public void removerProduto(String id) {
        repo.deleteById(id);
        
    }

   

    @Override
    public Optional<ProdutoDto> obterPorId(String id) {
       Optional<Produto> produto = repo.findById(id);

       if(produto.isPresent()){
           ProdutoDto prodDto = new ModelMapper().map(produto.get(), ProdutoDto.class);
           return Optional.of(prodDto);
       }
        return Optional.empty();
    }



    

    @Override
    public ProdutoDto atualizarProduto(String id, ProdutoDto produtos) {
        ModelMapper mp = new ModelMapper();
        Produto prod = mp.map(produtos, Produto.class);
        prod.setId(id);
        prod = repo.save(prod);

        return mp.map(prod, ProdutoDto.class);
    }
    

    
}
