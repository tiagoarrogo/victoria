package com.tiagoarrogo.victoria.config;


import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class Config {
	
	
	 private static SessionFactory sessionFactory;
     
	    public static SessionFactory getSessionFactory() {
	        if (sessionFactory == null) {
	            // loads configuration and mappings
	            Configuration configuration = new Configuration().configure("/com/tiagoarrogo/victoria/config/hibernate.cfg.xml");
	            ServiceRegistry serviceRegistry
	                = new StandardServiceRegistryBuilder()
	                    .applySettings(configuration.getProperties()).build();
	             
	            // builds a session factory from the service registry
	            sessionFactory = configuration.buildSessionFactory(serviceRegistry);           
	        }
	         
	        return sessionFactory;
	    }
	    
	    
}
