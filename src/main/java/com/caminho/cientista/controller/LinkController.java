package com.caminho.cientista.controller;
import  com.caminho.cientista.model.Link;
import com.caminho.cientista.service.LinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/Link")
public class LinkController {
    @Autowired
    private LinkService service;
    @PostMapping
    public String  post(@RequestBody Link link){
        service.criar(link);
        return "Link INCLUIDA COM SUCESSO";
    }
    @GetMapping
    public List<Link> get (){

        return service.listar();
    }
    @PutMapping
    public String put (@RequestBody Link link){
        service.editar(link);
        return "Link EDITADA COM SUCESSO";
    }
    @DeleteMapping("/{id}")
    public String del (@PathVariable int id){
        service.deletar(id);
        return "Link DELETADA COM SUCESSO";
    }

}
