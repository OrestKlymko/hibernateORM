package org.study;

import org.study.service.ClientCrudService;

public class Main {
	public static void main(String[] args) {
		ClientCrudService clientCrudService = new ClientCrudService();
		System.out.println(clientCrudService.getCountTickets(1));
	}
}
