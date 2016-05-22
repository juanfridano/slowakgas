package com.slogas.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.springframework.stereotype.Component;

@Component("gasDAO")
public class GasDAO {
	
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("persepolis");
	
	
	public void Persister (GasEntity gas){
		EntityManager em = emf.createEntityManager();
		EntityTransaction txn = em.getTransaction();
		
		txn.begin();
		em.persist(gas);
		txn.commit();
		em.close();

	}
	
	@SuppressWarnings("unchecked")
	public List<GasEntity> Results(String startDate, String endDate){
		List<GasEntity> temp = new ArrayList<>();
		
		EntityManager em = emf.createEntityManager();
		EntityTransaction txn = em.getTransaction();
		txn.begin();
		Query query = em.createQuery("FROM GasEntity e WHERE e.date BETWEEN " + startDate + " AND " + endDate);
		temp= query.getResultList();
		txn.commit();
		em.close();
		
		return temp;
	}
	
}
