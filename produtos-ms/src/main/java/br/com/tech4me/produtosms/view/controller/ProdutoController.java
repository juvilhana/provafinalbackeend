package br.com.tech4me.produtosms.view.controller;

import br.com.tech4me.produtosms.service.ProdutoService;
import br.com.tech4me.produtosms.view.model.ProdutoModeloResponse;
import br.com.tech4me.produtosms.view.model.ProdutoModeloInclusao;
import br.com.tech4me.produtosms.compartilhado.ProdutoDto;


import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;




@RestController
@RequestMapping("/api/produtos")
public class ProdutoController {
    @Autowired
    private ProdutoService service;

    @GetMapping
    public ResponseEntity<List<ProdutoModeloResponse>> obterTodos() {
        ModelMapper mapper = new ModelMapper();
        List<ProdutoDto> dtos = service.obterTodos();
        List<ProdutoModeloResponse> resp = dtos.stream()
        .map(dto -> mapper.map(dto, ProdutoModeloResponse.class))
        .collect(Collectors.toList());

        return new ResponseEntity<>(resp, HttpStatus.OK);
        
    }

    @GetMapping(value="/{id}")
    public ResponseEntity<ProdutoModeloResponse> obterProduto(@PathVariable String id) {
        Optional<ProdutoDto> prod = service.obterPorId(id);

        if(prod.isPresent()) {
            return new ResponseEntity<>(
            new ModelMapper().map(prod.get(), ProdutoModeloResponse.class), 
                HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

   

    
   
    @GetMapping(value = "/status")
    public String status(@Value("${local.server.port}") String porta){
        return String.format("Serviço rodando na porta %s", porta);
    }

    @PostMapping
    public ResponseEntity<ProdutoModeloResponse> criandoProduto(@RequestBody @Valid ProdutoModeloInclusao produto){
        ModelMapper mapper =new ModelMapper();
        ProdutoDto dto = mapper.map(produto, ProdutoDto.class);
        dto = service.criarProduto(dto);
        return new ResponseEntity<>(mapper.map(dto, ProdutoModeloResponse.class), HttpStatus.CREATED);
       
    }

    @DeleteMapping(value="/{id}")
    public ResponseEntity<Void> remover(@PathVariable String id) {
        Optional<ProdutoDto> prod = service.obterPorId(id);
        if(prod.isPresent()){
            service.removerProduto(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
       
        
    }

   

    

    @PutMapping(value="/{id}")
    public ResponseEntity<ProdutoModeloResponse> atualizarProduto(@PathVariable String id,
        @Valid @RequestBody  ProdutoModeloInclusao produto) {
        ModelMapper mapper = new ModelMapper();
        ProdutoDto dto = mapper.map(produto, ProdutoDto.class);
        dto = service.atualizarProduto(id, dto);

        return new ResponseEntity<>(mapper.map(dto, ProdutoModeloResponse.class), HttpStatus.OK);
    }

    





    
}
