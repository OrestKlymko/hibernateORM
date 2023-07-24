package org.study;

import org.study.database.DatabaseInitService;
import org.study.entity.Client;
import org.study.entity.Planet;
import org.study.service.ClientCrudService;
import org.study.service.PlanetCrudService;

public class Main {
	public static void main(String[] args) {
		new DatabaseInitService().migrateDatabase();
//		ClientCrudService clientService = new ClientCrudService();
//		Client client = new Client();
//		client.setName("New client");
//		clientService.createClient(client);
//		clientService.updateClient(1,"Name Changed");// updated
//		System.out.println(clientService.getClient(1));//get by id
//		clientService.deleteClient(2);// delete by id
//		clientService.deleteClient(2);// delete by id



		PlanetCrudService planet = new PlanetCrudService();
		Planet neptun = new Planet();
		neptun.setId("Neptun");
		neptun.setPlanetName("Neptun");

		planet.createPlanet(neptun); // create new planet
		planet.updatePlanet("neptun","NePtUn"); // update planet
		System.out.println(planet.getPlanet("neptun"));// get planet by id
		planet.deletePlanet("neptun"); // delete planet
	}
}
