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


	public Ticket getTicket(int id){
		try(Session session = sessionFactory.openSession()) {
			return session.get(Ticket.class,id);
		}catch (Exception e){
			throw new RuntimeException("Unknown ticket");
		}
	}

	public List<Ticket> getAllTickets(){
		try(Session session = sessionFactory.openSession()) {
			return session.createQuery("from Ticket").getResultList();
		}catch (Exception e){
			throw new RuntimeException("Error with something");
		}
	}

	public void createTicket(int idClient, String fromPlanet, String toPlanet) {
		try (Session session = sessionFactory.openSession()) {
			transaction = session.beginTransaction();
			Client client = new ClientCrudService().getClient(idClient);

			Planet fromPlanetFind = session.get(Planet.class,fromPlanet);
			Planet toPlanetFind = session.get(Planet.class,toPlanet);
			
			if (client!=null&&fromPlanetFind!=null&&toPlanetFind!=null) {
				Ticket ticket = new Ticket();
				ticket.setClient(client);
				ticket.setPlanetFrom(fromPlanetFind);
				ticket.setPlanetTo(toPlanetFind);
				session.persist(ticket);
				transaction.commit();
			} else {
				System.out.println("Please check your input data");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void deleteTicket(int clientID, Ticket ticket) {
		try (Session session = sessionFactory.openSession()) {
			transaction = session.beginTransaction();
			Client client = new ClientCrudService().getClient(clientID);
			if (client!=null) {
				Ticket findTicket = client.getTickets().get(ticket.getId());
				session.remove(findTicket);
				transaction.commit();
			}else {
				System.out.println("Client not found");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void updateTicket(int idTicket, Ticket ticket) {
		try (Session session = sessionFactory.openSession()) {
			transaction = session.beginTransaction();
			Ticket ticket1 = getTicket(idTicket);
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
