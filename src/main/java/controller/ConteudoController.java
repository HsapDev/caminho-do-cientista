package controller;

import model.Conteudo;
import service.ConteudoService;

import java.util.List;

public class ConteudoController {
    private ConteudoService service = new ConteudoService();


    public String post (int idmateria,String titulo, String texto, String formula){//precisa idConteudi titulo,texto,formula
        Conteudo novoConteudo = new Conteudo();
        novoConteudo.setMateriaId(idmateria);
        novoConteudo.setTitulo(titulo);
        novoConteudo.setTexto(texto);
        novoConteudo.setFormula(formula);
        service.editar(novoConteudo);

    return "Conteudo criado com sucesso";
    }
    public List<Conteudo> get (){
        return service.listar();
    }

    public String put (int id,String titulo, String texto, String formula){
        Conteudo edicaoConteudo=new Conteudo();
        edicaoConteudo.setId(id);
        edicaoConteudo.setTitulo(titulo);
        edicaoConteudo.setTexto(texto);
        edicaoConteudo.setFormula(formula);
        service.editar(edicaoConteudo);
        return "CONTEUDO EDITADO COM SUCESSO";
    }

    public String del (int id){
        service.deletar(id);
        return "CONTEUDO DELETADO COM SUCESSO";
    }

}
