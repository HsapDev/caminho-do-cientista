package com.caminho.cientista.controller;



import com.caminho.cientista.model.Videos;
import com.caminho.cientista.service.VideosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/video")
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
