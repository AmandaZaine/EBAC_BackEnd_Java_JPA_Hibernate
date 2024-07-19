package dao;

import domain.Matricula;
import org.junit.Test;

import java.time.Instant;

import static org.junit.Assert.*;

public class MatriculaDaoTest {
    private IMatriculaDao matriculaDao;

    public MatriculaDaoTest() {
        matriculaDao = new MatriculaDao();
    }

    @Test
    public void cadastrar() {
        Matricula matricula = new Matricula();
        matricula.setCodigo("M1");
        matricula.setData(Instant.now());
        matricula.setValor(1500d);

        matricula = matriculaDao.cadastrar(matricula);
        assertNotNull(matricula);
        assertNotNull(matricula.getCodigo());
    }
}