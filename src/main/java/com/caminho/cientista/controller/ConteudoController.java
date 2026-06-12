package com.caminho.cientista.controller;
import com.caminho.cientista.model.Conteudo;
import com.caminho.cientista.service.ConteudoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping("/conteudo")
@CrossOrigin(origins ="*")
public class ConteudoController {
    @Autowired
    private ConteudoService service;

    @PostMapping
    public String post (@RequestBody Conteudo conteudo){
        service.editar(conteudo);

    return "Conteudo criado com sucesso";
    }
    @GetMapping
    public List<Conteudo> get (){
        return service.listar();
    }

    @GetMapping("/{id}")
    public Conteudo getById (@PathVariable int id)
    {Conteudo c = service.buscarPorId(id);
        return service.buscarPorId(id);
    }


    @PutMapping
    public String put (@RequestBody Conteudo conteudo){

        service.editar(conteudo);
        return "CONTEUDO EDITADO COM SUCESSO";
    }
    @DeleteMapping("/{id}")
    public String del (@PathVariable int id){
        service.deletar(id);
        return "CONTEUDO DELETADO COM SUCESSO";
    }

}
