package controller;

import model.Link;
import service.LinkService;

import java.util.List;

public class LinkController {
    private LinkService service = new LinkService();
    //conteudo_id,enunciado,resposta,resolucao
    public String  post(int conteudoId,String titulo,String url){
        Link criarLink = new Link();
        criarLink.setConteudo_id(conteudoId);
        criarLink.setTitulo(titulo);
        criarLink.setUrl(url);
        service.criar(criarLink);
        return "Link INCLUIDA COM SUCESSO";
    }

    public List<Link> get (){

        return service.listar();
    }

    public String put (int conteudoId,String titulo,String url){
        Link editarLink = new Link();
        editarLink.setConteudo_id(conteudoId);
        editarLink.setTitulo(titulo);
        editarLink.setUrl(url);
        service.editar(editarLink);
        return "Link EDITADA COM SUCESSO";
    }

    public String del (int id){
        service.deletar(id);
        return "Link DELETADA COM SUCESSO";
    }

}
