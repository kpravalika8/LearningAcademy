package com.dxc.models;

import javax.imageio.spi.ServiceRegistry;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	
	 static Session sessionObj;
	    static SessionFactory sessionFactoryObj;
	 
	    public static SessionFactory buildSessionFactory() {
	        
	        Configuration configObj = new Configuration();
	        configObj.configure("hibernate.cfg.xml");
	 
	       
	        StandardServiceRegistry serviceRegistryObj = new StandardServiceRegistryBuilder().applySettings(configObj.getProperties()).build(); 
	 
	   
	        sessionFactoryObj = configObj.buildSessionFactory(serviceRegistryObj);
	        return sessionFactoryObj;
	    }

}
	
	 