package org.example;

import model.classes.Customer;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.service.ServiceRegistry;

public class Main {
    public static void main(String[] args) {

        {
            try {
                // Create the SessionFactory from hibernate.cfg.xml
                Configuration configuration = new Configuration();
                configuration.configure("hibernate.cfg.xml");
                System.out.println("Hibernate Configuration loaded");

                ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
                System.out.println("Hibernate serviceRegistry created");

                SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);

                return;
            } catch (Throwable ex) {
                System.err.println("Initial SessionFactory creation failed." + ex);
                ex.printStackTrace();
                throw new ExceptionInInitializerError(ex);
            }
        }



       // public static SessionFactory getSessionFactory () {
          //  if (getSessionFactory == null) getSessionFactory = buildSessionFactory();
           // return getSessionFactory;
        }
    }