package com.caminho.cientista.controller;



import com.caminho.cientista.model.Materia;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.caminho.cientista.service.MateriaService;

import java.util.List;
@RestController
@RequestMapping("/materias")

public class MateriaController {

    @Autowired
    private MateriaService service;
    @Autowired
    private Materia materia;


    @PostMapping
    public String post (@RequestBody Materia materia){
        service.inserir(materia);
    return "materia criada com sucesso!";
    }
    @GetMapping
    public List<Materia> get (){
            return service.listar();
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
