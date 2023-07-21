package org.study.service;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.study.database.HibernateUtil;
import org.study.entity.Client;
import java.util.List;

public class ClientCrudService {
	private final Session session = HibernateUtil.getInstance().getSessionFactory().openSession();
	private Transaction transaction;

	public List<Client> getAllClients(){
		return session.createQuery("from Client ").getResultList();
	}

	public Client getClient(int id){
		return session.get(Client.class,id);

	}

	public void createClient(Client newClient){
		try {
			transaction = session.beginTransaction();
			session.persist(newClient);
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

	public void deleteClient(int findId){
		try {
			transaction = session.beginTransaction();
			Client client = session.get(Client.class, findId);
			session.remove(client);
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

	public void updateClient(int id, String name){
		try {
			transaction = session.beginTransaction();
			Client client = session.get(Client.class, id);
			client.setName(name);
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
