package Matricula;

public class Main {
    public static void main(String[] args) {
        Aluno aluno = new Aluno("alkdlska", "danbiel", 13);
        AlunoService alunos = new AlunoService();

        alunos.cadastrar(aluno);

        alunos.listarAlunos();

        System.out.println(alunos.listarAlunos());
    }
}
