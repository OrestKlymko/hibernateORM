package org.study.service;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;
import org.study.database.HibernateUtil;
import org.study.entity.Client;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

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
	public int getCountTickets(int id) {
		NativeQuery nativeQuery = session.createNativeQuery("SELECT COUNT(*) FROM ticket WHERE client_id = ?");
		nativeQuery.setParameter(1, id);
		List<Object> result = nativeQuery.getResultList();
		if (!result.isEmpty() && result.get(0) instanceof Number) {
			Number count = (Number) result.get(0);
			return count.intValue();
		} else {
			return 0;
		}
	}

}
