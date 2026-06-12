package model;

public class Conteudo {
    private int id;
    private int materiaId;
    private String titulo;
    private String texto;
    private String formula;

    //getters e setters


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMateriaId() {
        return materiaId;
    }

    public void setMateriaId(int materiaId) {
        this.materiaId = materiaId;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public String getFormula() {
        return formula;
    }

    public void setFormula(String formula) {
        this.formula = formula;
    }

    public Conteudo (){}
    public Conteudo(String titulo, String texto, String formula){
        this.formula=formula;
        this.texto=texto;
        this.titulo=titulo;
    }
}
