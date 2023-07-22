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

	public Planet getPlanet(String id){
		return session.get(Planet.class,id.toUpperCase());

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

	public void deletePlanet(String findId){
		try{
			transaction = session.beginTransaction();
			Planet planet = session.get(Planet.class, findId.toUpperCase());
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

	public void updatePlanet(String id, String name){
		try {
			transaction = session.beginTransaction();
			Planet planet = session.get(Planet.class, id.toUpperCase());
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
