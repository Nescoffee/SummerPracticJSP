package model;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class TestJpa {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		EntityManagerFactory emf =
		Persistence.createEntityManagerFactory("JPAJPAJPA");
	EntityManager em = emf.createEntityManager();
	Query q = em.createNamedQuery("Manager.findAll");
	List<Manager> list = q.getResultList();
	for (Manager room : list) {
		System.out.println(room.getZakaz().getVisitor().getEmail());
	}
}
}