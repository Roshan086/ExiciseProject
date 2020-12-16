/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.exices.taxation.dao;

import com.exices.taxation.models.EmployeeModel;
import java.util.List;

/**
 *
 * @author Roshan
 */
public interface EmployeeDAO {
    List<EmployeeModel> getAllEmployee();
    List<EmployeeModel> getAllEmployeesByRows(Integer firstValue, Integer noOfRows);
    EmployeeModel createEmployee(EmployeeModel employeeModel);
    EmployeeModel deleteEmployee(EmployeeModel employeeModel);
    EmployeeModel updateEmployee(EmployeeModel employeeModel);
    EmployeeModel getEmployeeByEmployeeId(Integer employeeId);
    
}
