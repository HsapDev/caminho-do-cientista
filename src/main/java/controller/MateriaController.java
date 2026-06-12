package controller;


import model.Materia;
import service.MateriaService;

import java.util.ArrayList;
import java.util.List;

public class MateriaController {
    private MateriaService service = new MateriaService();
    private Materia materia = new Materia();

    public String post (String nome,String descricao){
        Materia novaMateria = new Materia();
        novaMateria.setNome(nome);
        novaMateria.setDescricao(descricao);
        service.inserir(novaMateria);
    return "materia criada com sucesso!";
    }

    public List<Materia> get (){
            return service.listar();
    }

    public String put (String nome, String descricao, int id){
        Materia editarMateria = new Materia();
        editarMateria.setNome(nome);
        editarMateria.setDescricao(descricao);
        editarMateria.setId(id);
        service.editar(editarMateria);
        return "materia editada com sucesso!";
    }

    public String del (int id){
        Materia excluirMateria = new Materia();
        excluirMateria.setId(id);
        service.deletar(id);
        return "materia excluida com sucesso";
    }








}
