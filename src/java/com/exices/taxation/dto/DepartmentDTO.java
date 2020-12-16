/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.exices.taxation.dto;

import java.util.List;

/**
 *
 * @author Roshan
 */
public class DepartmentDTO extends GeneralDTO{
    private String id;
    private String name;
    private List<EmployeeDTO> employees;
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<EmployeeDTO> getEmployees() {
        return employees;
    }

    public void setEmployees(List<EmployeeDTO> employees) {
        this.employees = employees;
    }
    

    @Override
    public String toString() {
        return "DepartmentDTO{" + "id=" + id + ", name=" + name + '}';
    }
    
    
    
}
