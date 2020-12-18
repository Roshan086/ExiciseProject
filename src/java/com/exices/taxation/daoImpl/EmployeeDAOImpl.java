/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.exices.taxation.daoImpl;

import com.exices.taxation.dao.EmployeeDAO;
import com.exices.taxation.models.DepartmentModel;
import com.exices.taxation.models.EmployeeModel;
import com.exices.taxation.util.HibernateUtil;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author Roshan
 */
public class EmployeeDAOImpl implements EmployeeDAO{

    private SessionFactory factory;
    
    @Override
    public List<EmployeeModel> getAllEmployee() {
        factory = HibernateUtil.buildFactory();
        Session session = factory.openSession();
        session.beginTransaction();

        List<EmployeeModel> employeeModels = session.createQuery("FROM EmployeeModel").list();

        session.getTransaction().commit();
        session.close();

        return employeeModels;
    }

    @Override
    public EmployeeModel createEmployee(EmployeeModel employeeModel) {
        factory = HibernateUtil.buildFactory();
        Session session = factory.openSession();
        session.beginTransaction();

        session.save(employeeModel);
        
        session.getTransaction().commit();
        session.close();

        return employeeModel;
    }

    @Override
    public EmployeeModel deleteEmployee(EmployeeModel employeeModel) {
        factory = HibernateUtil.buildFactory();
        Session session = factory.openSession();
        session.beginTransaction();

        session.delete(employeeModel);
        
        session.getTransaction().commit();
        session.close();

        return employeeModel;
    }

    @Override
    public EmployeeModel updateEmployee(EmployeeModel employeeModel) {
        factory = HibernateUtil.buildFactory();
        Session session = factory.openSession();
        session.beginTransaction();

        session.update(employeeModel);
        
        session.getTransaction().commit();
        session.close();
        
        return employeeModel;
    }

    @Override
    public EmployeeModel getEmployeeByEmployeeId(Integer employeeId) {
        factory = HibernateUtil.buildFactory();
        Session session = factory.openSession();
        session.beginTransaction();

        EmployeeModel employeeModel = (EmployeeModel) session.get(EmployeeModel.class, employeeId);
        
        session.getTransaction().commit();
        session.close();
        
        return employeeModel;
    }

    @Override
    public List<EmployeeModel> getAllEmployeesByRows(Integer firstValue, Integer noOfRows) {
        factory = HibernateUtil.buildFactory();
        Session session = factory.openSession();
        session.beginTransaction();
        
        Query hql = session.createQuery("FROM EmployeeModel");
        hql.setFirstResult(firstValue);
        hql.setMaxResults(noOfRows);

        List<EmployeeModel> employees = hql.list();
        
        session.getTransaction().commit();
        session.close();
        
        return employees;
        
    }

    @Override
    public Integer getTableSize() {
        factory = HibernateUtil.buildFactory();
        Session session = factory.openSession();
        session.beginTransaction();
        
        Integer sizeOfTable = session.createQuery("from EmployeeModel").list().size();
        
        session.getTransaction().commit();
        session.close();
        
        return sizeOfTable;
        
    }
    
}
