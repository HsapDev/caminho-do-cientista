package com.caminho.cientista.controller;

import com.caminho.cientista.model.Conteudo;
import com.caminho.cientista.model.Link;
import com.caminho.cientista.model.Questoes;
import com.caminho.cientista.service.QuestoesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/questoes")
@CrossOrigin(origins = "*")
public class QuestoesController {
    @Autowired
    private QuestoesService service;
    @PostMapping
    public String post (@RequestBody Questoes questoes){

        service.inserir(questoes);
        return "QUESTAO INCLUIDA COM SUCESSO";
    }
    @GetMapping
    public List<Questoes> get (){

        return service.listar();
    }

    @GetMapping("/{id}")
    public Questoes getById (@PathVariable int id)
    {Questoes q = service.buscarPorId(id);
        return service.buscarPorId(id);
    }

    @GetMapping("/por-conteudo/{idconteudo}")
    public List<Questoes> getByConteudoId (@PathVariable int idconteudo)
    {
        return service.buscarPorConteudoId(idconteudo);
    }

    @PutMapping
    public String put (@RequestBody Questoes questoes){
        service.editar(questoes);
        return "QUESTAO EDITADA COM SUCESSO";
    }
    @DeleteMapping("/{id}")
    public String del (@PathVariable int id){
        service.excluir(id);
        return "QUESTAO DELETADA COM SUCESSO";
    }

}
