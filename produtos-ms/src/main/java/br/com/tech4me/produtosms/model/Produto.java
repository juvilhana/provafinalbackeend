package br.com.tech4me.produtosms.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("produtos")
public class Produto {
    @Id
    private String id;
    private int codigo;
    private String nome;
    private double valor;
    private int quantidadeEstoque;


    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
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

    @Override
    public String toString() {
        return "Produto [id=" + id + ", nome=" + nome + ", quantidadeEstoque=" + quantidadeEstoque + ", valor="
                + valor + "]";
    }

    
    
}
