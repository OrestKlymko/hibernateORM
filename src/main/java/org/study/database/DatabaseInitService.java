package org.study.database;


import org.flywaydb.core.Flyway;

public class DatabaseInitService {

	public static void main(String[] args) {
		Flyway flyway = Flyway.configure().dataSource(DbConstants.CONNECTION_URL,"","").load();
		flyway.migrate();
	}
}