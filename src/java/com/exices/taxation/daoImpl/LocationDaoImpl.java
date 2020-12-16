/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.exices.taxation.daoImpl;

import com.exices.taxation.dao.LocationDAO;
import com.exices.taxation.models.LocationModel;
import com.exices.taxation.util.HibernateUtil;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author Abdul Waqar
 */
public class LocationDaoImpl implements LocationDAO {

    @Override
    public List<LocationModel> getAllLocations() {

        Session openSession = HibernateUtil.buildFactory().openSession();
        List<LocationModel> locations = (List<LocationModel>) openSession.createQuery("From LocationModel").list();

        return locations;
    }

    @Override
    public void addLocation(LocationModel locaton) {
        Session openSession = HibernateUtil.buildFactory().openSession();
        openSession.beginTransaction();
        openSession.save(locaton);
        openSession.getTransaction().commit();
        openSession.close();
    }

    @Override
    public List<LocationModel> getAllDistricts() {

        Session openSession = HibernateUtil.buildFactory().openSession();
        List<LocationModel> districts = (List<LocationModel>) openSession.createQuery("From LocationModel where parent_location_id IS NULL").list();
        return districts;
    }

    @Override
    public LocationModel getLocationById(Integer locationId) {
        HibernateUtil.buildFactory().openSession();
        return null;
    }

}
