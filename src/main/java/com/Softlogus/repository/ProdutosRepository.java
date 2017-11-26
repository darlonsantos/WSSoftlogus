package com.Softlogus.repository;


import com.softlogus.entity.ProdutosEntity;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ProdutosRepository {

   private  final  EntityManagerFactory entityManagerFactory;
   private  final EntityManager entityManager;

   public ProdutosRepository() {
      this.entityManagerFactory = Persistence.createEntityManagerFactory("persistence");
      this.entityManager = this.entityManagerFactory.createEntityManager();

   }
   public void Salvar(ProdutosEntity produtosEntity){
      this.entityManager.getTransaction().begin();
      this.entityManager.persist(produtosEntity);
      this.entityManager.getTransaction().commit();
   }

   public void Alterar(ProdutosEntity produtosEntity){
      this.entityManager.getTransaction().begin();
      this.entityManager.merge(produtosEntity);
      this.entityManager.getTransaction().commit();
   }

   public List<ProdutosEntity> listaProdutosEntity() {
       return this.entityManager.createQuery("select p from ProdutosEntity p order by p.produto").getResultList();
   }

   public ProdutosEntity getProdutosEntity(Integer idProduto){
    return  this.entityManager.find(ProdutosEntity.class, idProduto);
  }

  public void Excluir(Integer idProduto){
     ProdutosEntity produtosEntity = this.getProdutosEntity(idProduto);

     this.entityManager.getTransaction().begin();
     this.entityManager.remove(produtosEntity);
     this.entityManager.getTransaction().commit();

  }

}
