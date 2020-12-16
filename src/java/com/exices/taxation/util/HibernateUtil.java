package com.exices.taxation.util;


import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil 
{
    private static SessionFactory factory;
    
    public static SessionFactory buildFactory(){
        if(factory == null){
            Configuration configuration = new Configuration();
            factory = configuration.configure().buildSessionFactory();
        }
        
        return factory;
    }
    
}
