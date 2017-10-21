package com.dao.repository;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public abstract class Connection {
    protected SessionFactory connection;
    protected Session session;
    public Connection(){
        connection = new Configuration().configure().buildSessionFactory();
      //  session = connection.openSession();
    }

    protected void beginTransaction(){

        session = connection.openSession();
        session.beginTransaction();
    }

    protected void endTransaction(){
        session.getTransaction().commit();
        connection.close();
    }



}
