import dao.ConteudoDao;
import dao.MateriaDAO;
import model.Conteudo;
import model.Materia;
import service.MateriaService;


public class Main {
    public static void main(String[] args) {

        // 1. Instanciar os DAOs
        MateriaService materiaService = new MateriaService();
        ConteudoDao conteudoDAO = new ConteudoDao();

        // 2. Inserir uma Matéria nova
        Materia novaMateria = new Materia("Java Avançado", "Estudo de Spring Boot");
        materiaService.inserir(novaMateria);

        // Dica: Na prática, você buscaria o ID da matéria que acabou de inserir
        int idDaMateria = 1; // Ajuste para o ID que apareceu no seu banco

        // 3. Inserir um Conteúdo vinculado a essa Matéria
        Conteudo novoConteudo = new Conteudo();
        novoConteudo.setMateriaId(idDaMateria);
        novoConteudo.setTitulo("Injeção de Dependência");
        novoConteudo.setTexto("Conceitos de Spring");
        novoConteudo.setFormula("N/A");

        conteudoDAO.inserir(novoConteudo);

        // 4. Listar tudo para provar que a "ponte" entre as tabelas funciona
//        System.out.println("--- RESULTADO DO BANCO ---");
//        System.out.println("Matérias:");
//        for(Materia m : materiaService.listar()) {
//            System.out.println(m.getNome());
//        }
//
//        System.out.println("Conteúdos:");
//        for(Conteudo c : conteudoDAO.listar()) {
//            System.out.println("Título: " + c.getTitulo() + " | Matéria ID: " + c.getMateriaId());
//        }
    }
}