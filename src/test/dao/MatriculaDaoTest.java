package dao;

import domain.Aluno;
import domain.Curso;
import domain.Matricula;
import org.junit.Test;

import java.time.Instant;

import static org.junit.Assert.*;

public class MatriculaDaoTest {
    private IMatriculaDao matriculaDao;
    private ICursoDao cursoDao;
    private IAlunoDao alunoDao;

    public MatriculaDaoTest() {
        matriculaDao = new MatriculaDao();
        cursoDao = new CursoDao();
        alunoDao = new AlunoDao();
    }

    @Test
    public void cadastrar() {
        Curso curso = criarCurso("C1");
        Aluno aluno = criarAluno("A1");

        Matricula matricula = new Matricula();
        matricula.setCodigo("M1");
        matricula.setData(Instant.now());
        matricula.setValor(1500d);
        matricula.setCurso(curso);
        matricula.setAluno(aluno);
        aluno.setMatricula(matricula);
        matricula = matriculaDao.cadastrar(matricula);

        assertNotNull(matricula);
        assertNotNull(matricula.getCodigo());
    }

    private Curso criarCurso(String codigo) {
        Curso curso = new Curso();
        curso.setCodigo(codigo);
        curso.setNome("Curso" + codigo);
        return cursoDao.cadastrar(curso);
    }

    private Aluno criarAluno(String codigo) {
        Aluno aluno = new Aluno();
        aluno.setCodigo(codigo);
        aluno.setNome("Aluno " + codigo);
        return alunoDao.cadastrar(aluno);
    }
}