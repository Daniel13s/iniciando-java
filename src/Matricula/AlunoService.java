package Matricula;

import com.sun.jdi.OpaqueFrameException;

import java.lang.classfile.Opcode;
import java.util.*;

public class AlunoService {
    private Map<String, Aluno> alunos = new HashMap<>();
    private List<Aluno> alunosList = new ArrayList<>();

    public void cadastrar(Aluno aluno) {
        if(alunos.containsKey(aluno.getMatricula())) {
            throw new IllegalArgumentException("Matricula existente");
        }
        alunos.put(aluno.getMatricula(), aluno);
        alunosList.add(aluno);
    }
    public Optional<Aluno> buscarPorMatricula(String matricula) {
        if(alunos.containsKey(matricula)) {
            return Optional.of(alunos.get(matricula));
        }
        return Optional.empty();
    }
    public List<Aluno> listarAlunos() {
        return alunosList.stream().toList();
    }
    public List<Aluno> buscarMaioresDeIdade() {
        return alunosList.stream().filter(aluno -> aluno.getIdade() >= 18).toList();
    }
}
