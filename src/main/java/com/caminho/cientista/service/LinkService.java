package com.caminho.cientista.service;

import com.caminho.cientista.dao.LinkDao;
import com.caminho.cientista.model.Conteudo;
import com.caminho.cientista.model.Link;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class LinkService {
    private LinkDao dao = new LinkDao();

    public void criar(Link link){
        if (link.getTitulo() == null){throw new IllegalArgumentException("ERRO: TITULO VAZIO");}
        if (link.getUrl()== null){throw new IllegalArgumentException("ERRO: LINK VAZIO");}
        dao.inserir(link);
    }
    public List<Link> listar (){
        return dao.listar();
    }

    public Link buscarPorId(int id) {
        if (id < 0) {
            throw new IllegalArgumentException("ERRO: ID NAO EXISTE");
        }
        return dao.buscarPorId(id);

    }

    public List<Link> buscarPorIdConteudo(int id){
        if (id<0){throw  new IllegalArgumentException("ERRO: ID NAO EXISTE");}
        return dao.buscarPorConteudoId(id);
    }
    public void editar (Link link){
        if (link.getId()<0){throw new IllegalArgumentException("ERRO: ID NAO EXISTE");}
    }
    public void deletar (int id){if (id< 0){throw new IllegalArgumentException("ERRO: INDICE NAO EXISTE");} dao.excluir(id);}


}
