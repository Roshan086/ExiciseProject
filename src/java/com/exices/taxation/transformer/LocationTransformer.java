package com.exices.taxation.transformer;

import com.exices.taxation.dto.LocationDTO;
import com.exices.taxation.models.LocationModel;
import java.util.ArrayList;
import java.util.List;

public class LocationTransformer {

    public static List<LocationDTO> getAllLocations(List<LocationModel> locationModels) {

        List<LocationDTO> locationDTO = new ArrayList<LocationDTO>();
        for (LocationModel model : locationModels) {
            locationDTO.add(LocationTransformer.getLocationDTOByLocationModel(model));
        }

        return locationDTO;
    }

    public static LocationDTO getLocationDTOByLocationModel(LocationModel locationModel) {
        LocationDTO locationDTO = new LocationDTO();

        if (locationModel.getId() != null) {
            locationDTO.setId(locationModel.getId().toString());
        }

        if (locationModel.getLocationName() != null) {
            locationDTO.setLocationName(locationModel.getLocationName());
        }

        if (locationModel.getLocation() != null) {
            LocationDTO locationDTO1 = new LocationDTO();
            locationDTO1.setId(locationModel.getLocation().getId().toString());
            locationDTO.setLocation(locationDTO1);
        }
        return locationDTO;
    }

    public static LocationModel getLocationModelByLocationDTO(LocationDTO locationDTO) {

        LocationModel locationModel = new LocationModel();
        if (locationDTO.getId() != null) {
            locationModel.setId(Integer.parseInt(locationDTO.getId()));
        }

        if (locationDTO.getLocationName() != null) {
            locationModel.setLocationName(locationDTO.getLocationName());
        }

        return locationModel;
    }

}
