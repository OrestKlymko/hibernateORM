package org.study.database;


import org.flywaydb.core.Flyway;

public class DatabaseInitService {

	public void migrateDatabase() {
		Flyway flyway = Flyway.configure().dataSource(DbConstants.CONNECTION_URL,"","").load();
		flyway.migrate();
	}
}