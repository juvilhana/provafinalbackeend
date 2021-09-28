package br.com.tech4me.primeirorest.view.controller;
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

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.tech4me.primeirorest.compartilhado.VendaDto;

import br.com.tech4me.primeirorest.service.VendaService;
import br.com.tech4me.primeirorest.view.model.VendaModeloRequest;
import br.com.tech4me.primeirorest.view.model.VendaModeloResponse;


@RestController
@RequestMapping("/api/vendas")
public class VendaController {
    @Autowired
    private VendaService service;

    @GetMapping(value="/status")
    public String statusServico(@Value("${local.server.port}") String porta) {
        return String.format("Serviço ativo e executando na porta %s", porta);
    }

    @GetMapping
    public ResponseEntity<List<VendaModeloResponse>> obterTodos() {
        List<VendaDto> dtos = service.obterTodos();

        if(dtos.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        ModelMapper mapper = new ModelMapper();
        List<VendaModeloResponse> resp = dtos.stream()
                    .map(dto -> mapper.map(dto, VendaModeloResponse.class))
                    .collect(Collectors.toList());

        return new ResponseEntity<>(resp, HttpStatus.OK);
    }

    @GetMapping(value="/{id}")
    public ResponseEntity<VendaModeloResponse> obterPorId(@PathVariable String id) {
        Optional<VendaDto> venda = service.obterPorId(id);

        if(venda.isPresent()) {
            return new ResponseEntity<>(
                new ModelMapper().map(venda.get(), VendaModeloResponse.class), 
                HttpStatus.OK
            );
        }

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping(value="/{id}")
    public ResponseEntity<Void> removerVenda(@PathVariable String id) {
        service.removerVenda(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    } 
    

    @PostMapping
    public ResponseEntity<VendaModeloResponse> criarVenda(@RequestBody @Valid VendaModeloRequest venda) {
        ModelMapper mapper = new ModelMapper();
       VendaDto dto = mapper.map(venda, VendaDto.class);
        Optional<VendaDto> dtos = service.criarVenda(dto);

        if(dtos.isPresent())
        {
            return new ResponseEntity<>(mapper.map(dtos.get(), VendaModeloResponse.class), HttpStatus.CREATED);   
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        
    }
    
    
    
   

    

    
}

    

