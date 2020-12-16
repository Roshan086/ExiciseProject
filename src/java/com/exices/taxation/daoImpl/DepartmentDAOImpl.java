/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.exices.taxation.daoImpl;

import com.exices.taxation.dao.DepartmentDAO;
import com.exices.taxation.models.DepartmentModel;
import com.exices.taxation.util.HibernateUtil;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author Roshan
 */
public class DepartmentDAOImpl implements DepartmentDAO {

    private SessionFactory factory;

    @Override
    public List<DepartmentModel> getAllDepartments() {
        factory = HibernateUtil.buildFactory();
        Session session = factory.openSession();
        session.beginTransaction();

        List<DepartmentModel> departmentModel = session.createQuery("FROM DepartmentModel").list();

        session.getTransaction().commit();
        session.close();

        return departmentModel; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public DepartmentModel createDepartment(DepartmentModel departmentModel) {
        Session openSession = HibernateUtil.buildFactory().openSession();
        openSession.beginTransaction();
        openSession.save(departmentModel);
        openSession.getTransaction().commit();
        openSession.close();
        return null;
    }

    @Override
    public void updateDepartment(DepartmentModel departmentModel) {
        factory = HibernateUtil.buildFactory();
        Session session = factory.openSession();
        session.beginTransaction();

        session.update(departmentModel);

        session.getTransaction().commit();
        session.close();

    }

    @Override
    public void deleteDepartment(DepartmentModel departmentModel) {
        factory = HibernateUtil.buildFactory();
        Session session = factory.openSession();
        session.beginTransaction();

        session.delete(departmentModel);

        session.getTransaction().commit();
        session.close();
    }

    @Override
    public DepartmentModel getDepartmentByDepartmentId(Integer departmentId) {
        factory = HibernateUtil.buildFactory();
        Session session = factory.openSession();
        session.beginTransaction();

//        DepartmentModel departmentModel =  (DepartmentModel) session.load(DepartmentModel.class, departmentId);
        DepartmentModel departmentModel = (DepartmentModel) session.createQuery("From DepartmentModel where id=" + departmentId).list().get(0);
        session.getTransaction().commit();
        session.close();

        return departmentModel;
    }

    @Override
    public List<DepartmentModel> getByPagi(int pageNumner, int pazeSize) {

        SessionFactory factory;
        factory = HibernateUtil.buildFactory();
        Session session = factory.openSession();
        session.beginTransaction();
        Query query = session.createQuery("FROM DepartmentModel");

        query.setFirstResult((pageNumner - 1) * pazeSize);
        query.setMaxResults(pazeSize);

        List<DepartmentModel> departments = query.list();

        session.getTransaction().commit();
        session.close();

        return departments;
    }

    @Override
    public List<DepartmentModel> getAllDepartmentsByRows(Integer firstValue, Integer noOfRows) {
        factory = HibernateUtil.buildFactory();
        Session session = factory.openSession();
        session.beginTransaction();

        Query hql = session.createQuery("FROM DepartmentModel");
        hql.setFirstResult(firstValue);
        hql.setMaxResults(noOfRows);

        List<DepartmentModel> departments = hql.list();

        session.getTransaction().commit();
        session.close(); 
        return departments;

    }
}
