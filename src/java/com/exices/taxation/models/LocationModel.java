package com.exices.taxation.models;

import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.hibernate.annotations.GeneratorType;

@Entity
@Table(name = "location")
public class LocationModel {

    @Id
    @Column(name = "location_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "location_name")
    private String locationName;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "parent_location_id")
    private LocationModel location;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLocationName() {
        return locationName;
    }

    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }

    public LocationModel getLocation() {
        return location;
    }

    public void setLocation(LocationModel location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "LocationModel{" + "id=" + id + ", locationName=" + locationName + ", location=" + location + '}';
    }
    
    
    
    
}
