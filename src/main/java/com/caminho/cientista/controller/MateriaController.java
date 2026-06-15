package com.caminho.cientista.controller;



import com.caminho.cientista.model.Conteudo;
import com.caminho.cientista.model.Materia;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.caminho.cientista.service.MateriaService;

import java.util.List;

@RestController
@RequestMapping("/materias")
@CrossOrigin(origins = "*")
public class MateriaController {

    @Autowired
    private MateriaService service;

    private Materia materia  = new Materia();


    @PostMapping
    public String post (@RequestBody Materia materia){
        service.inserir(materia);
    return "materia criada com sucesso!";
    }
    @GetMapping
    public List<Materia> get (){
            return service.listar();
    }

    @GetMapping("/{id}")
    public Materia getById (@PathVariable int id)
    {Materia m = service.buscarPorId(id);
        return service.buscarPorId(id);
    }

    @PutMapping
    public String put (@RequestBody Materia materia){
        service.editar(materia);
        return "materia editada com sucesso!";
    }
    @DeleteMapping("/{id}")
    public String del (@PathVariable int id){
        Materia excluirMateria = new Materia();
        excluirMateria.setId(id);
        service.deletar(id);
        return "materia excluida com sucesso";
    }








}
