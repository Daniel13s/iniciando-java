package Matricula;

public class Aluno {
    private final String matricula;
    private String nome;
    private int idade;

    public Aluno(String matricula, String nome, int idade) {
        if(matricula == null || matricula.isBlank()){
            throw new IllegalArgumentException("Matricula invalida");
        }
        if(nome == null || nome.isBlank()) {
            throw new IllegalArgumentException("Nome invalido");
        }
        if(idade < 4) {
            throw new IllegalArgumentException("Idade invalida");
        }

        this.matricula = matricula;
        this.nome = nome;
        this.idade = idade;
    }
    public String getMatricula() {
        return this.matricula;
    }
    public String getNome() {
        return this.nome;
    }
    public int getIdade() {
        return this.idade;
    }

    public void alterarNome(String novoNome) {
        if(novoNome == null || novoNome.isBlank()) {
            throw new IllegalArgumentException("Nome invalido");
        }

        this.nome = novoNome;
    }
    public void alterarIdade(int novaIdade) {
        if(novaIdade < 4) {
            throw new IllegalArgumentException("Idade invalida");
        }

        this.idade = novaIdade;
    }
}
