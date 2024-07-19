package dao;

import domain.Matricula;

public class MatriculaDao implements IMatriculaDao {
    @Override
    public Matricula cadastrar(Matricula matricula) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("modulo32");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(matricula);
        entityManager.getTransaction().commit();
        entityManager.close();
        entityManagerFactory.close();

        return matricula;
    }
}
