package br.com.tech4me.primeirorest.compartilhado;


import java.time.LocalDate;

public class VendaDto {
    private String id;
    private String idProduto;
    private String nomeDoProduto;
    private int quantidadeProduto;
    private double valorTotal;
    private LocalDate data;

    public String getIdProduto() {
        return idProduto;
    }
    public void setIdProduto(String idProduto) {
        this.idProduto = idProduto;
    }


    
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }

    public String getNomeDoProduto() {
        return nomeDoProduto;
    }
    public void setNomeDoProduto(String nomeDoProduto) {
        this.nomeDoProduto = nomeDoProduto;
    }
    public double getValorTotal() {
        return valorTotal;
    }
    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }
    public int getQuantidadeProduto() {
        return quantidadeProduto;
    }
    public void setQuantidadeProduto(int quantidadeProduto) {
        this.quantidadeProduto = quantidadeProduto;
    }

    public LocalDate getData() {
        return data;
    }
    public void setData(LocalDate data) {
        this.data = data;
    }
    



    
    
  



    




    
}
