package br.com.tech4me.produtosms.view.model;


import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

public class ProdutoModeloInclusao {
    @NotBlank(message = "Codigo não pode estar em branco")
    @NotEmpty(message = "Codigo não pode estar vazio")
    private int codigo;
    @NotEmpty(message = "Nome não pode estar vazio")
    private String nome;
    @NotEmpty(message = "Valor não pode estar vazio")
    private double valor;
    private int quantidadeEstoque;

    public int getCodigo() {
        return codigo;
    }
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public double getValor() {
        return valor;
    }
    public void setValor(double valor) {
        this.valor = valor;
    }
    public int getQuantidadeEstoque() {
        return quantidadeEstoque;
    }
    public void setQuantidadeEstoque(int quantidadeEstoque) {
        this.quantidadeEstoque = quantidadeEstoque;
    }

    
    
}
