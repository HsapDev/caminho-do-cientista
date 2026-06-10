public class videos {
    private int id;
    private int conteudo_id;
    private  String titulo;
    private String url;

    public int getId(){
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getConteudo_id() {
        return conteudo_id;
    }

    public void setConteudo_id(int conteudo_id) {
        this.conteudo_id = conteudo_id;
    }


    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
    public videos (){}
    public videos (String titulo,String url){
        this.titulo= titulo;
        this.url=url;
    }
}
