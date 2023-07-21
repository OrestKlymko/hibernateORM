package org.study.database;

import lombok.Getter;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.study.entity.Client;

public class HibernateUtil {
	private static final HibernateUtil INSTANCE;

	@Getter
	private SessionFactory sessionFactory;

	static {
		INSTANCE = new HibernateUtil();
	}

	private HibernateUtil() {
		sessionFactory = new Configuration()
				.addAnnotatedClass(Client.class)
				.addAnnotatedClass(Planet.class)
				.buildSessionFactory();
	}

	public static HibernateUtil getInstance() {
		return INSTANCE;
	}

	public void close() {
		sessionFactory.close();
	}
}
