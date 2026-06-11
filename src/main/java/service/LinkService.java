package service;

import dao.LinkDao;
import model.Link;

import java.util.List;

public class LinkService {
    private LinkDao dao = new LinkDao();

    public void criar(Link link){
        if (link.getTitulo() == null){throw new IllegalArgumentException("ERRO: TITULO VAZIO");}
        if (link.getUrl()== null){throw new IllegalArgumentException("ERRO: LINK VAZIO");}
        try {new java.net.URL(link.getUrl());
        }catch (java.net.MalformedURLException e){
            throw new IllegalArgumentException("ERRO: LINK NAO EXISTE");
        }
        dao.inserir(link);
    }
    public List<Link> listar (Link link){
        return dao.listar();
    }
    public void editar (Link link){
        if (link.getId()<0){throw new IllegalArgumentException("ERRO: ID NAO EXISTE");}
    }
    public void deletar (int id){if (id< 0){throw new IllegalArgumentException("ERRO: INDICE NAO EXISTE");} dao.excluir(id);}


}
