package com.softlogus.http;


import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Produtos {


    private Integer codigo;
    private Integer codBarra;
    private String produto;
    private String unidade;
  
    public Produtos(Integer codigo, Integer codBarra, String produtos, String unidade){
      super();
      this.codigo = codigo;
      this.codBarra = codBarra;
      this.produto = produtos;
      this.unidade = unidade;
      
    
    }

    public Integer getCodigo() {
		return codigo;
	}
    
    public Integer getCodBarra() {
		return codBarra;
	}
    
    public String getProduto() {
		return produto;
	}
    public String getUnidade() {
		return unidade;
	}
    
    public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}
    
    public void setCodBarra(Integer codBarra) {
		this.codBarra = codBarra;
	}
    public void setProduto(String produto) {
		this.produto = produto;
	}
    public void setUnidade(String unidade) {
		this.unidade = unidade;
	}
    
   
}
