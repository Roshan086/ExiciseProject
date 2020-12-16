/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.exices.taxation.dao;

import com.exices.taxation.models.LocationModel;
import java.util.List;

/**
 *
 * @author Abdul Waqar
 */
public interface LocationDAO {
    public List<LocationModel> getAllLocations();
    public List<LocationModel> getAllDistricts();
    public LocationModel getLocationById(Integer locationId);
    public void addLocation(LocationModel locaton);
}
