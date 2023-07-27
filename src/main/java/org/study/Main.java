package org.study;

import org.study.database.DatabaseInitService;
import org.study.entity.Client;
import org.study.entity.Ticket;
import org.study.service.ClientCrudService;
import org.study.service.TicketCrudService;

public class Main {
	public static void main(String[] args) {
		new DatabaseInitService().migrateDatabase();

		TicketCrudService ticketCrudService = new TicketCrudService();
		ClientCrudService clientCrudService = new ClientCrudService();




		Ticket newTicket = new Ticket();
		Client client = clientCrudService.getClient(1);

		newTicket.setClient(client);



//		ticketCrudService.createTicket(4,"MARS","VEN"); // create new ticket
//		ticketCrudService.updateTicket(1,newTicket); // update ticket in client
//		ticketCrudService.deleteTicket(client.getId(),newTicket); // delete ticket in client
		System.out.println(ticketCrudService.getTicket(2));
//		System.out.println(ticketCrudService.getAllTickets());

	}
}
