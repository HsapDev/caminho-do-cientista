package com.caminho.cientista.controller;



import com.caminho.cientista.model.Conteudo;
import com.caminho.cientista.model.Questoes;
import com.caminho.cientista.model.Videos;
import com.caminho.cientista.service.VideosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/video")
@CrossOrigin(origins = "*")
public class VideoController {
    @Autowired // serve para injetar o servico e economizar memoria
    private VideosService service;
    @PostMapping
    public String post (@RequestBody Videos video){
        service.criar(video);
        return "Video INCLUIDA COM SUCESSO";
    }
    @GetMapping
    public List<Videos> get (){

        return service.listar();
    }

    @GetMapping("/{id}")
    public Videos getById (@PathVariable int id)
    {Videos v = service.buscarPorId(id);
        return service.buscarPorId(id);
    }

    @GetMapping("/por-conteudo/{idconteudo}")
    public List<Videos> getByConteudoId (@PathVariable int idconteudo)
    {
        return service.buscarPorConteudoId(idconteudo);
    }



    @PutMapping
    public String put (@RequestBody Videos video){
        service.editar(video);
        return "Video EDITADA COM SUCESSO";
    }
    @DeleteMapping("/{id}")
    public String del (@PathVariable int id){
        service.deletar(id);
        return "Video DELETADA COM SUCESSO";
    }

}
