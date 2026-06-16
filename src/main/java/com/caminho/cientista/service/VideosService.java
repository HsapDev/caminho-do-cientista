package com.caminho.cientista.service;

import com.caminho.cientista.dao.VideosDao;
import com.caminho.cientista.model.Conteudo;
import com.caminho.cientista.model.Videos;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class VideosService {
    private VideosDao dao = new VideosDao();

    public void criar(Videos Videos){
        if (Videos.getTitulo() == null){throw new IllegalArgumentException("ERRO: TITULO VAZIO");}
        if (Videos.getUrl()== null){throw new IllegalArgumentException("ERRO: Videos VAZIO");}

        dao.inserir(Videos);
    }
    public List<Videos> listar (){
        return dao.listar();
    }

    public Videos buscarPorId(int id) {
        if (id < 0) {
            throw new IllegalArgumentException("ERRO: ID NAO EXISTE");
        }
        return dao.buscarPorId(id);

    }

    public List<Videos> buscarPorConteudoId(int id){
        if (id<0){throw  new IllegalArgumentException("ERRO: ID NAO EXISTE");}
        return dao.buscarPorConteudoId(id);
    }

    public void editar (Videos Videos){
        if (Videos.getId()<0){throw new IllegalArgumentException("ERRO: ID NAO EXISTE");}
    }
    public void deletar (int id){if (id< 0){throw new IllegalArgumentException("ERRO: INDICE NAO EXISTE");} dao.excluir(id);}


}
