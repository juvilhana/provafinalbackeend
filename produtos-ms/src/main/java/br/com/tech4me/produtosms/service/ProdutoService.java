package br.com.tech4me.produtosms.service;

import br.com.tech4me.produtosms.compartilhado.ProdutoDto;
import java.util.List;
import java.util.Optional;

public interface ProdutoService {

List<ProdutoDto> obterTodos();
ProdutoDto criarProduto(ProdutoDto pessoa);
void removerProduto(String id);
Optional<ProdutoDto> obterPorId(String id);
ProdutoDto atualizarProduto(String id, ProdutoDto produto);



}
