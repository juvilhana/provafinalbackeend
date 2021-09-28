package br.com.tech4me.primeirorest.clienteHTTP;

import java.util.ArrayList;
import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import br.com.tech4me.primeirorest.compartilhado.Produto;

@FeignClient(name= "produto-ms", fallback = ProdutosFeignClientFallback.class)
public interface ProdutosFeignClient {
    @GetMapping(path = "/api/produtos/{nome}/lista")
    List<Produto> obterProdutos(@PathVariable String nome);   
}

@Component
class ProdutosFeignClientFallback implements ProdutosFeignClient {

    @Override
    public List<Produto> obterProdutos(String nome) {
        return new ArrayList<>();
    }}
    