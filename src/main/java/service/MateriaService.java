package service;

import dao.MateriaDAO;
import model.Materia;

import java.util.List;

public class MateriaService {

    private MateriaDAO dao = new MateriaDAO();

    public void inserir (Materia materia){
        if (materia.getNome() ==null || materia.getNome().trim().isEmpty()){
            System.err.println("ERRO: o nome da materia é obrigatorio");
            return;
        }
        if (materia.getNome().length()<3){
            System.err.println("errO: o nome da materia é muito curto!");
            return;
        }
        dao.inserir(materia);
        System.out.println("Materia registrada com segurança pelo service");
    }

    public List<Materia> listar (Materia materia){
        return dao.listar();
    }

    public void editar (Materia materia){
        if (materia.getId()<0){
            throw new IllegalArgumentException("ERRO:Id de materia invalida");
        }
        dao.editar(materia);

    }

    public void deletar (int id){
        if (id<0){
            throw new IllegalArgumentException("ERRO: id de materia invalida");
        }
        dao.excluir(id);

    }
}
