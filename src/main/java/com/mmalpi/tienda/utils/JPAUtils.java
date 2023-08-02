package com.mmalpi.tienda.utils;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtils {

	//instance the entity using the name created in the persistence.xml //instancia la entidad usando el nombre declarado en el xml
	private static EntityManagerFactory Factory = Persistence.createEntityManagerFactory("tienda");
	
	public static EntityManager getEntityManager() {
		return Factory.createEntityManager();
	}
}
