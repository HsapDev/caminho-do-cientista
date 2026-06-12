package com.caminho.cientista.service;


import com.caminho.cientista.model.Questoes;
import com.caminho.cientista.dao.QuestoesDao;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class QuestoesService {

    private QuestoesDao dao = new QuestoesDao();

    public void inserir (Questoes questoes){
        if (questoes.getConteudoId()<0){throw new IllegalArgumentException("ERRO: ID DE QUESTAO NAO ENCONTRADO");}
        if (questoes.getEnunciado()==null){throw new IllegalArgumentException("ERRO: ENUNCIADO VAZIO");}
        if (questoes.getResposta()==null){throw new IllegalArgumentException("ERRO: RESPOSTA VAZIA");}
        if (questoes.getResolucao()==null){throw new IllegalArgumentException("ERRO: RESOLUCAO NAO ENCONTRADA");}
        dao.inserir(questoes);
    }
    public List<Questoes> listar (){
        return dao.listar();
    }

    public void editar (Questoes questoes){
        if (questoes.getConteudoId()<0){throw new IllegalArgumentException("ERRO: ID DE QUESTAO NAO ENCONTRADO");}
        dao.editar(questoes);
    }

    public void excluir (int id){if (id<0){
        throw new IllegalArgumentException("ERRO: ID NAO ENCONTRADO"); }
        dao.deletar(id);
    }
}
