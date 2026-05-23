public class Aluno {
    private String nome;
    private int idade;
    private String matricula;
    private String curso;

    public Aluno(String nome, int idade, String matricula, String curso) {
        this.nome = nome;
        this.idade = idade;
        this.matricula = matricula;
        this.curso = curso;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }



}

