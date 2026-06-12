package controller;

import model.Questoes;
import service.QuestoesService;

import java.util.List;

public class QuestoesController {
    private QuestoesService service = new QuestoesService();
    //conteudo_id,enunciado,resposta,resolucao
    public String post (int conteudoId,String enunciado,String resposta,String resolucao){
        Questoes criarQuestoes = new Questoes();
        criarQuestoes.setConteudoId(conteudoId);
        criarQuestoes.setEnunciado(enunciado);
        criarQuestoes.setResolucao(resolucao);
        criarQuestoes.setResposta(resposta);
        service.inserir(criarQuestoes);
        return "QUESTAO INCLUIDA COM SUCESSO";
    }

    public List<Questoes> get (){

        return service.listar();
    }

    public String put (int id,String enunciado,String resposta,String resolucao){
        Questoes criarQuestoes = new Questoes();
        criarQuestoes.setId(id);
        criarQuestoes.setEnunciado(enunciado);
        criarQuestoes.setResolucao(resolucao);
        criarQuestoes.setResposta(resposta);
        service.editar(criarQuestoes);
        return "QUESTAO EDITADA COM SUCESSO";
    }

    public String del (int id){
        service.excluir(id);
        return "QUESTAO DELETADA COM SUCESSO";
    }

}
