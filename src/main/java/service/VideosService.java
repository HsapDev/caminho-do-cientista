package service;

import dao.VideosDao;
import model.Videos;

import java.util.List;

public class VideosService {
    private VideosDao dao = new VideosDao();

    public void criar(Videos Videos){
        if (Videos.getTitulo() == null){throw new IllegalArgumentException("ERRO: TITULO VAZIO");}
        if (Videos.getUrl()== null){throw new IllegalArgumentException("ERRO: Videos VAZIO");}
        try {new java.net.URL(Videos.getUrl());
        }catch (java.net.MalformedURLException e){
            throw new IllegalArgumentException("ERRO: Videos NAO EXISTE");
        }
        dao.inserir(Videos);
    }
    public List<Videos> listar (){
        return dao.listar();
    }
    public void editar (Videos Videos){
        if (Videos.getId()<0){throw new IllegalArgumentException("ERRO: ID NAO EXISTE");}
    }
    public void deletar (int id){if (id< 0){throw new IllegalArgumentException("ERRO: INDICE NAO EXISTE");} dao.excluir(id);}


}
