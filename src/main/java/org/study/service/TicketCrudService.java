package org.study.service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.study.database.HibernateUtil;
import org.study.entity.Client;
import org.study.entity.Planet;
import org.study.entity.Ticket;

import java.util.List;

public class TicketCrudService {
	private final SessionFactory sessionFactory = HibernateUtil.getInstance().getSessionFactory();
	private Transaction transaction;

	public List<Ticket> getAllTicketsOfClient(int id) {
		try (Session session = sessionFactory.openSession()) {
			Client client = session.get(Client.class, id);
			return client.getTickets();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public void buyTicket(int idClient, Planet fromPlanet, Planet toPlanet) {
		try (Session session = sessionFactory.openSession()) {
			transaction = session.beginTransaction();
			Client client = session.get(Client.class, idClient);
			Ticket ticket = new Ticket();
			ticket.setClient(client);
			ticket.setPlanetFrom(fromPlanet);
			ticket.setPlanetTo(toPlanet);
			session.persist(ticket);
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void returnTicket(int clientID, Ticket ticket) {
		try (Session session = sessionFactory.openSession()) {
			transaction = session.beginTransaction();
			Client client = session.get(Client.class, clientID);
			Ticket findTicket = client.getTickets().get(ticket.getId());
			session.remove(findTicket);
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void changeTicket(int idTicket, Ticket ticket) {
		try (Session session = sessionFactory.openSession()) {
			transaction = session.beginTransaction();
			Ticket ticket1 = session.get(Ticket.class, idTicket);
			if(ticket1!=null){
				ticket1.setPlanetFrom(ticket.getPlanetFrom());
				ticket1.setPlanetTo(ticket.getPlanetTo());
				ticket1.setClient(ticket.getClient());
			}
			session.merge(ticket1);
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
