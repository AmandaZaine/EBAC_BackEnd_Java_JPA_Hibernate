package dao;

import domain.Curso;
import org.junit.Test;

import static org.junit.Assert.*;

public class CursoDaoTest {

    private ICursoDao cursoDao;

    public CursoDaoTest() {
        cursoDao = new CursoDao();
    }

    @Test
    public void cadastrar() {
        Curso curso = new Curso();
        curso.setCodigo("C1");
        curso.setNome("Java BackEnd");

        curso = cursoDao.cadastrar(curso);

        assertNotNull(curso);
        assertNotNull(curso.getId());
    }
}