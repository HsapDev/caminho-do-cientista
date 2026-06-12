package controller;

import model.Videos;
import service.VideosService;

import java.util.List;

public class VideoController {
    private VideosService service = new VideosService();
    //conteudo_id,enunciado,resposta,resolucao
    public String post (int conteudoId,String titulo,String url){
        Videos criarVideos = new Videos();
        criarVideos.setConteudo_id(conteudoId);
        criarVideos.setTitulo(titulo);
        criarVideos.setUrl(url);
        service.criar(criarVideos);
        return "Video INCLUIDA COM SUCESSO";
    }

    public List<Videos> get (){

        return service.listar();
    }

    public String put (int conteudoId,String titulo,String url){
        Videos editarVideos = new Videos();
        editarVideos.setConteudo_id(conteudoId);
        editarVideos.setTitulo(titulo);
        editarVideos.setUrl(url);
        service.editar(editarVideos);
        return "Video EDITADA COM SUCESSO";
    }

    public String del (int id){
        service.deletar(id);
        return "Video DELETADA COM SUCESSO";
    }

}
