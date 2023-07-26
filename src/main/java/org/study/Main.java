package org.study;

import org.study.database.DatabaseInitService;
import org.study.entity.Client;
import org.study.entity.Planet;
import org.study.entity.Ticket;
import org.study.service.ClientCrudService;
import org.study.service.PlanetCrudService;
import org.study.service.TicketCrudService;

public class Main {
	public static void main(String[] args) {
		new DatabaseInitService().migrateDatabase();

		TicketCrudService ticketCrudService = new TicketCrudService();
		ClientCrudService clientCrudService = new ClientCrudService();




		Ticket newTicket = new Ticket();
		Client client = clientCrudService.getClient(1);

		newTicket.setClient(client);



		ticketCrudService.buyTicket(4,"MARS","VEN"); // create new ticket
		ticketCrudService.changeTicket(1,newTicket); // update ticket in client
		System.out.println(ticketCrudService.getAllTicketsOfClient(1)); // get ticket in client
		ticketCrudService.returnTicket(client.getId(),newTicket); // delete ticket in client

	}
}
