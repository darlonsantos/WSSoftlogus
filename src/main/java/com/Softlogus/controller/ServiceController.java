package com.softlogus.controller;


import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import com.Softlogus.repository.ProdutosRepository;
import com.softlogus.entity.ProdutosEntity;
import com.softlogus.http.Produtos;


/**
 * Essa classe vai expor os nossos métodos para serem acessasdos via http
 *
 * @Path - Caminho para a chamada da classe que vai representar o nosso serviço
 * <p>
 * Darlon Santos de Carvalho
 */
@Path("/service")
public class ServiceController {
    private final ProdutosRepository repository = new ProdutosRepository();


    /**
     * @Consumes - determina o formato dos dados que vamos postar
     * @Produces - determina o formato dos dados que vamos retornar
     *
     */


    @POST
    @Consumes("application/json; charset=UTF-8")
    @Produces("application/json; charset=UTF-8")
    @Path("/cadastrar")
    public String Cadastra(Produtos produtos) {
        ProdutosEntity entity = new ProdutosEntity();
        try {
         	entity.setCodigo(produtos.getCodigo());
            entity.setCodBarras(produtos.getCodBarra());
            entity.setProduto(produtos.getProduto());
            entity.setUnidade(produtos.getUnidade());
            repository.Salvar(entity);
            return "Registro cadastrado com sucesso!";
        } catch (Exception e) {
            return "Erro ao cadastra registro!";

        }

    }

/**
 *
 *
 * Essse método altera um produto já cadastrado
 *
 * Darlon Santos
 * **/

    @PUT
    @Produces("application/json; charset=UTF-8")
    @Consumes("application/json; charset=UTF-8")
    @Path("/alterar")

    public String Alterar(Produtos produtos){
     ProdutosEntity entity = new ProdutosEntity();
        try {
         	entity.setCodigo(produtos.getCodigo());
            entity.setCodBarras(produtos.getCodBarra());
            entity.setProduto(produtos.getProduto());
            entity.setUnidade(produtos.getUnidade());
            repository.Salvar(entity);
            return "Registro alterado com sucesso!";
        } catch (Exception e) {
            return "Erro ao alterar registro!";

        }

    }

    /**
     * Esse método lista todos produtos na base
     *
     * Darlon Santos de Carvalho
     * */
    @GET
    @Produces("application/json; charset=UTF-8")
    @Path("/todosProdutos")
    public List<Produtos> TodosProdutos(){
        List<Produtos> produtos =  new ArrayList<Produtos>();
        List<ProdutosEntity> listaEntitypProdutos = repository.listaProdutosEntity();
        for (ProdutosEntity entity : listaEntitypProdutos) {
            produtos.add(new Produtos(entity.getCodigo(),
                    entity.getCodBarras(),
                    entity.getProduto(),
                    entity.getUnidade()));
        }

        return produtos;
    }


    /**
     * Esse método busca um produto cadastrado pelo Id
     *
     * Darlon Santos de Carvalho
     *
     * */
    @GET
    @Produces("application/json; charset=UTF-8")
    @Path("/getProdutos/{codigo}")
    public Produtos GetProdutos(@PathParam("codigo") Integer idProdutos){
        ProdutosEntity entity = repository.getProdutosEntity(idProdutos);
        if(entity != null)
            return new Produtos(entity.getCodigo(),
        entity.getCodBarras(),
                entity.getProduto(),
                entity.getUnidade());

        return null;
    }
    /**
     * Excluindo um produto pelo Id
     * */
    @DELETE
    @Produces("application/json; charset=UTF-8")
    @Path("/excluir/{idProduto}")
    public String Excluir(@PathParam("idProduto") Integer idProduto){
        try {
            repository.Excluir(idProduto);
            return "Registro excluido com sucesso!";
        } catch (Exception e) {
            return "Erro ao excluir o registro! " + e.getMessage();
        }

    }




}
