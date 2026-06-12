package com.caminho.cientista.controller;

import com.caminho.cientista.model.Questoes;
import com.caminho.cientista.service.QuestoesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/questoes")
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
