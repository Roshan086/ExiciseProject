/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.exices.taxation.dao;

import com.exices.taxation.models.DepartmentModel;
import java.util.List;

/**
 *
 * @author Roshan
 */
public interface DepartmentDAO {
    List<DepartmentModel> getAllDepartments();
    DepartmentModel createDepartment(DepartmentModel departmentModel);
    void updateDepartment(DepartmentModel departmentModel);
    void deleteDepartment(DepartmentModel departmentModel);
    DepartmentModel getDepartmentByDepartmentId(Integer departmentId);
    public List<DepartmentModel> getByPagi(int pageNumner, int pazeSize);
    public List<DepartmentModel> getAllDepartmentsByRows(Integer firstValue, Integer noOfRows);
}
