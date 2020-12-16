/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.exices.taxation.daoImpl;

import com.exices.taxation.dao.UserDAO;
import com.exices.taxation.models.UserModel;
import com.exices.taxation.util.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author Roshan
 */
public class UserDAOImpl implements UserDAO{

    private SessionFactory factory;
    
    @Override
    public UserModel getUserByLoginCredentials(String userName, String password) {
        factory = HibernateUtil.buildFactory();
        Session session = factory.openSession();
        session.beginTransaction();

        Query query = session.createQuery("FROM UserModel WHERE name = :username AND password = :password");
        query.setParameter("username", userName);
        query.setParameter("password", password);
        UserModel user = (UserModel) query.uniqueResult();

        session.getTransaction().commit();
        session.close();

        return user;
    }
    
}
