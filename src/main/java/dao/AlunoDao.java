package dao;

import domain.Aluno;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class AlunoDao implements IAlunoDao {
    @Override
    public Aluno cadastrar(Aluno aluno) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("modulo32");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(aluno);
        entityManager.getTransaction().commit();
        entityManager.close();
        entityManagerFactory.close();

        return aluno;
    }
}
