package br.com.tech4me.primeirorest.view.model;

import java.time.LocalDate;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;


public class VendaModeloRequest {

    @NotBlank(message = "O nome deve possuir caracteres não brancos")
    @NotEmpty(message = "O nome deve ser preenchido")
    private String nomeDoProduto;
    @NotBlank(message = "O valor deve possuir caracteres não brancos")
    @NotEmpty(message = "O valor deve ser preenchido")
    private int valorTotal;
    private String idProduto;
    private int quantidadeProduto;
    private LocalDate data;  


    public String getNomeDoProduto() {
        return nomeDoProduto;
    }
    public void setNomeDoProduto(String nomeDoProduto) {
        this.nomeDoProduto = nomeDoProduto;
    }
    public int getValorTotal() {
        return valorTotal;
    }
    public void setValorTotalo(int valorTotal) {
        this.valorTotal= valorTotal;
    }
    public int getQuantidadeProduto() {
        return quantidadeProduto;
    }
    public void setQuantidadeProduto(int quantidadeProduto) {
        this.quantidadeProduto = quantidadeProduto;
    }
        public void setIdProduto(String idProduto) {
            this.idProduto = idProduto;
        }

     public String getIdProduto() {
     return idProduto;

        }
    }
        
       


    




    


    
