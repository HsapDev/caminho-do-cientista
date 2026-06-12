package com.caminho.cientista.service;

import com.caminho.cientista.dao.ConteudoDao;
import com.caminho.cientista.model.Conteudo;

import java.util.List;

public class ConteudoService {
    private ConteudoDao dao = new ConteudoDao();
    public void criar (Conteudo conteudo){
        if (conteudo.getMateriaId()<0){throw  new IllegalArgumentException("ERRO: NAO TEM ID DE MATERIA");}// int nunca é nulo, entao tem que ser maior que zero
        if (conteudo.getTitulo()==null){throw  new IllegalArgumentException("ERRO: TITULO NULO");}
        if (conteudo.getTexto()==null){throw  new IllegalArgumentException("ERRO: TEXTO NULO");}
        dao.inserir(conteudo);
    }
    public List<Conteudo> listar (){
        return dao.listar();
    }
    public void editar (Conteudo conteudo){
        if (conteudo.getMateriaId()<0){throw  new IllegalArgumentException("ERRO: ID MATERIA INEXISTENTE");}
        dao.editar(conteudo);
    }
    public void deletar (int id) {
        if (id<0){throw  new IllegalArgumentException("ERRO: ID NAO EXISTE");}
        dao.delete(id);
    }

}
