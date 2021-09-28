package br.com.tech4me.primeirorest.service;

import java.util.List;
import java.util.Optional;

import br.com.tech4me.primeirorest.compartilhado.VendaDto;

public interface VendaService {
    Optional<VendaDto> criarVenda(VendaDto venda);
    List<VendaDto> obterTodos();
    Optional<VendaDto> obterPorId(String id);
    void removerVenda(String id);
    
    
}
