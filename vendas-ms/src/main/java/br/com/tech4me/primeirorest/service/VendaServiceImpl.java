package br.com.tech4me.primeirorest.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import br.com.tech4me.primeirorest.compartilhado.VendaDto;
import br.com.tech4me.primeirorest.model.Venda;
import br.com.tech4me.primeirorest.repository.VendaRepository;
import br.com.tech4me.primeirorest.compartilhado.Produto;
import br.com.tech4me.primeirorest.repository.ProdutoRepositorio;

@Service
public class VendaServiceImpl implements VendaService {
    @Autowired
    private VendaRepository repo;

    @Autowired
    private ProdutoRepositorio repositorioProduto;

    @Override
    public List<VendaDto> obterTodos() {
        List<Venda> vendas = repo.findAll();

        return vendas.stream()
            .map(v -> new ModelMapper().map(v, VendaDto.class))
            .collect(Collectors.toList());
    }

    @Override
    public Optional<VendaDto> obterPorId(String id) {
       Optional<Venda> venda = repo.findById(id);

        
       if(venda.isPresent()) {
          VendaDto dto = new ModelMapper().map(venda.get(), VendaDto.class);
           
           return Optional.of(dto);
       }

       return Optional.empty();
    }

    @Override
    public void removerVenda(String id) {
        Optional<Venda> venda = repo.findById(id);
        List<Produto> produtos = repositorioProduto.findAll();
        if(venda.isPresent())
        {
            for(Produto produto : produtos)
            {
                if(produto.getId().equals(venda.get().getIdProduto()))
                {

                produto.setQuantidadeEstoque(produto.getQuantidadeEstoque()+venda.get().getQuantidadeProduto());
                repositorioProduto.save(produto);        
                repo.deleteById(id);
            
                }           
            }      
        }
        
    }


    @Override
    public Optional<VendaDto> criarVenda(VendaDto venda) {
        ModelMapper mapper = new ModelMapper();
        Venda vend = mapper.map(venda, Venda.class);

        List<Produto> produtos = repositorioProduto.findAll();

        for(Produto produto : produtos){
            if(produto.getId().equals(venda.getIdProduto())){
                produto.setQuantidadeEstoque(produto.getQuantidadeEstoque()-venda.getQuantidadeProduto());
                repositorioProduto.save(produto);
                vend.setNomeDoProduto(produto.getNome());
                vend.setValorTotal(venda.getQuantidadeProduto() * produto.getValor());
                vend = repo.save(vend);


                return Optional.of(mapper.map(vend, VendaDto.class));
            }

        }
        
        return Optional.empty();
    }

            }
       
   

    
    

   


    

