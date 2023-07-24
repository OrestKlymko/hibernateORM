package org.study.service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.study.database.HibernateUtil;
import org.study.entity.Planet;

import java.util.List;

public class PlanetCrudService {
	private final SessionFactory sessionFactory = HibernateUtil.getInstance().getSessionFactory();
	private Transaction transaction;

	public List<Planet> getAllPlanets(){
		Session session = sessionFactory.openSession();
		try {
			return session.createQuery("from Planet").getResultList();
		}catch (Exception e){
			throw new RuntimeException("Something wrong");
		}finally {
			session.close();
		}

	}

	public Planet getPlanet(String id){
		Session session = sessionFactory.openSession();
		try {
			return session.get(Planet.class,id.toUpperCase());
		}catch (Exception e){
			throw new RuntimeException("Something wrong");
		}finally {
			session.close();
		}


	}

	public void createPlanet(Planet newPlanet){
		Session session = sessionFactory.openSession();
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
		Session session = sessionFactory.openSession();
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
		Session session = sessionFactory.openSession();
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
