package com.softlogus.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.glassfish.jersey.internal.inject.Custom;

/*
 * TODO 
 * Tabela de produtros 
 * */
@Entity
@Table(name = "C000025")
public class ProdutosEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CODIGO")
    private Integer codigo;
     
	@Column(name = "CODBARRA")
	private Integer codBarras;
	
	@Column(name = "PRODUTO")
	private String produto;
	
	@Column(name = "UNIDADE")
	private String unidade;
   
    public Integer getCodBarras() {
		return codBarras;
	}
    
    public void setCodBarras(Integer codBarras) {
		this.codBarras = codBarras;
	}
    
    public String getProduto() {
		return produto;
	}
   
    public void setProduto(String produto) {
		this.produto = produto;
	}
    public Integer getCodigo() {
		return codigo;
	}
    
    public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}
    
    
    public String getUnidade() {
		return unidade;
	}
    public void setUnidade(String unidade) {
		this.unidade = unidade;
	}
}
