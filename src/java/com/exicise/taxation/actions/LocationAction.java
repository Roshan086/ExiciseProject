/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.exicise.taxation.actions;

import com.exices.taxation.dao.LocationDAO;
import com.exices.taxation.daoImpl.LocationDaoImpl;
import com.exices.taxation.dto.LocationDTO;
import com.exices.taxation.models.LocationModel;
import com.exices.taxation.transformer.LocationTransformer;
import com.exices.taxation.util.HibernateUtil;
import com.opensymphony.xwork2.ActionSupport;
import java.util.List;

/**
 *
 * @author Abdul Waqar
 */
public class LocationAction extends ActionSupport {
    private String locationId;
    private String locationName;
    private String location;
    private LocationDAO locationDAO = new LocationDaoImpl();
    private String selectLocation;
    private List<LocationModel> districtLocations;

    @Override
    public String execute() throws Exception {
        return super.execute(); //To change body of generated methods, choose Tools | Templates.
    }

    public String getAllLocations() {
        System.out.println("getAllLocations()  ");
        districtLocations = locationDAO.getAllDistricts();
        return SUCCESS;
    }

    public String checkLocationEntries() {

        return SUCCESS;
    }

    public String addDistrict() {
        LocationDTO locationDTO = new LocationDTO();
        locationDTO.setLocationName(locationName);
        LocationModel locationModel = LocationTransformer.getLocationModelByLocationDTO(locationDTO);
        locationDAO.addLocation(locationModel);

        return SUCCESS;
    }
    
    
//    public String addTaluka(){
//        System.out.println("locationId " +locationId);
//        System.out.println("locationName " +locationName);
//        System.out.println("location" +location);
//        districtLocations = locationDAO.getAllDistricts();
//        return SUCCESS;
//    }

//    Getters & Setters 
    public String getLocationName() {
        return locationName;
    }

    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getSelectLocation() {
        return selectLocation;
    }

    public void setSelectLocation(String selectLocation) {
        this.selectLocation = selectLocation;
    }

    public String getLocationId() {
        return locationId;
    }

    public void setLocationId(String locationId) {
        this.locationId = locationId;
    }

    public List<LocationModel> getDistrictLocations() {
        return districtLocations;
    }

    public void setDistrictLocations(List<LocationModel> districtLocations) {
        this.districtLocations = districtLocations;
    }

}
