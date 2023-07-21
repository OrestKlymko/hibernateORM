package org.study.service;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.study.database.HibernateUtil;
import org.study.entity.Planet;

import java.util.List;

public class PlanetCrudService {
	private final Session session = HibernateUtil.getInstance().getSessionFactory().openSession();
	private Transaction transaction;

	public List<Planet> getAllPlanets(){
		return session.createQuery("from Planet").getResultList();
	}

	public Planet getPlanet(int id){
		return session.get(Planet.class,id);

	}

	public void createPlanet(Planet newPlanet){
		try {
			transaction = session.beginTransaction();
			session.persist(newPlanet);
			transaction.commit();
			session.close();
		}catch (Exception e){
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}


	}

	public void deletePlanet(int findId){
		try{
			transaction = session.beginTransaction();
			Planet planet = session.get(Planet.class, findId);
			session.remove(planet);
			transaction.commit();
			session.close();
		}catch (Exception e){
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}

	}

	public void updatePlanet(int id, String name){
		try {
			transaction = session.beginTransaction();
			Planet planet = session.get(Planet.class, id);
			planet.setPlanetName(name);
			transaction.commit();
			session.close();
		}catch (Exception e){
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}

	}
}
