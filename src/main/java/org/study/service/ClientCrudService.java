package org.study.service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;
import org.study.database.HibernateUtil;
import org.study.entity.Client;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

public class ClientCrudService {
	private final SessionFactory sessionFactory = HibernateUtil.getInstance().getSessionFactory();
	private Transaction transaction;

	public List<Client> getAllClients() {
		Session session = sessionFactory.openSession();
		try {
			return session.createQuery("from Client ").getResultList();
		} catch (Exception e){
			throw new RuntimeException("Something wrong");
		}
			finally {
			session.close();
		}
	}

	public Client getClient(int id) {
		Session session = sessionFactory.openSession();
		try {
			return session.get(Client.class, id);
		}catch (Exception e) {
			throw new RuntimeException("Id "+id+" not found");
		} finally{
			session.close();
		}
	}

	public void createClient(Client newClient) {
		Session session = sessionFactory.openSession();
		try {
			transaction = session.beginTransaction();
			session.persist(newClient);
			transaction.commit();
			session.close();
		} catch (Exception e) {
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

	public void deleteClient(int findId) {
		Session session = sessionFactory.openSession();
		try {
			transaction = session.beginTransaction();
			Client client = session.get(Client.class, findId);
			session.remove(client);
			transaction.commit();
			session.close();
		} catch (Exception e) {
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

	public void updateClient(int id, String name) {
		Session session = sessionFactory.openSession();
		try {
			transaction = session.beginTransaction();
			Client client = session.get(Client.class, id);
			client.setName(name);
			transaction.commit();
			session.close();
		} catch (Exception e) {
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
