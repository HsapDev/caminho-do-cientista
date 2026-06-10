public class Questoes {
    private int id;
    private int conteudoId;
    private String enunciado;
    private String resolucao;
    private String resposta;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getConteudoId() {
        return conteudoId;
    }

    public void setConteudoId(int conteudoId) {
        this.conteudoId = conteudoId;
    }

    public String getEnunciado() {
        return enunciado;
    }

    public void setEnunciado(String enunciado) {
        this.enunciado = enunciado;
    }

    public String getResolucao() {
        return resolucao;
    }

    public void setResolucao(String resolucao) {
        this.resolucao = resolucao;
    }

    public String getResposta() {
        return resposta;
    }

    public void setResposta(String resposta) {
        this.resposta = resposta;
    }

    public Questoes(){};

    public Questoes (String enunciado,String resolucao,String resposta){
        this.enunciado =enunciado;
        this.resolucao =resolucao;
        this.resposta=resposta;
    }
}
