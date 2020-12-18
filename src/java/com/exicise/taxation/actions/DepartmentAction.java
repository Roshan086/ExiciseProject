/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.exicise.taxation.actions;

import com.exices.taxation.dao.DepartmentDAO;
import com.exices.taxation.daoImpl.DepartmentDAOImpl;
import com.exices.taxation.dto.DepartmentDTO;
import com.exices.taxation.models.DepartmentModel;
import com.exices.taxation.transformer.DepartmentTransformer;
import static com.opensymphony.xwork2.Action.SUCCESS;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.ServletActionContext;

public class DepartmentAction extends ActionSupport {

    public List<DepartmentDTO> departments;
    DepartmentDAO departmentDAO = new DepartmentDAOImpl();
    public Integer id = 0; //<Bilal> department id
    public String name; //<Bilal> department name
    public int noOfRows;
    private int totalRows;
    public int pageNo = 1;
    public int totalPages;
    private Integer firstValue = 0;
    private Map<String, Object> jsonData = new HashMap<String, Object>();

    public String getAllDepartments() {
        System.out.println("noOfRows " + noOfRows);
        System.out.println("pageNo " + pageNo);
        List<DepartmentModel> departmentsList = departmentDAO.getAllDepartmentsByRows(firstValue, 5);
        //System.out.println("Department >>> " + departmentsList.get(0));
        departments = DepartmentTransformer.getAllDepartments(departmentsList);
        //System.out.println("department " + departments.get(0).getName());
        totalRows = departments.size();
        return "success";
    }

    public String deleteDepartment() {

        System.out.println("Delete >>>> ");
        DepartmentModel departmentModel = departmentDAO.getDepartmentByDepartmentId(id);
        departmentDAO.deleteDepartment(departmentModel);

        getAllDepartments();
        return SUCCESS;
    }

    public String editDepartment() {
        System.out.println("editDepartment");
        if (id == 0) {
            return "save";
        } else {
            HttpServletRequest request = (HttpServletRequest) ActionContext.getContext()
                    .get(ServletActionContext.HTTP_REQUEST);
            System.out.println(">>>>>>>>>> request " + request.getParameter("id"));
            return SUCCESS;
        }
    }

    public String updateDepartment() {
        System.out.println("name >> " + name);
        System.out.println("Id >> " + id);
        DepartmentDTO departmentDto = new DepartmentDTO();
        departmentDto.setId(id.toString());
        departmentDto.setName(name);
        //DepartmentTransformer.updateDepartment(departmentDto);
        DepartmentModel departmentModel = DepartmentTransformer.getDepartmentModelByDepartentDTO(departmentDto);
        departmentDAO.updateDepartment(departmentModel);
        getAllDepartments();
        return SUCCESS;
    }

    public String addDepartment() {
        DepartmentDTO departmentDto = new DepartmentDTO();
        departmentDto.setName(name);
        DepartmentModel departmentModel = DepartmentTransformer.getDepartmentModelByDepartentDTO(departmentDto);
        departmentDAO.createDepartment(departmentModel);
        getAllDepartments();
        return SUCCESS;
    }

    public String cancelEditDepartment() {
        getAllDepartments();
        return SUCCESS;

    }

    //<Bilal> Getters and Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getNoOfRows() {
        return noOfRows;
    }

    public void setNoOfRows(int noOfRows) {
        this.noOfRows = noOfRows;
    }

    public Map<String, Object> getJsonData() {
        return jsonData;
    }

    public void setJsonData(Map<String, Object> jsonData) {
        this.jsonData = jsonData;
    }

    public int getPageNo() {
        return pageNo;
    }

    public void setPageNo(int pageNo) {
        this.pageNo = pageNo;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    public Integer getFirstValue() {
        return firstValue;
    }

    public void setFirstValue(Integer firstValue) {
        this.firstValue = firstValue;
    }

    public int getTotalRows() {
        return totalRows;
    }

    public void setTotalRows(int totalRows) {
        this.totalRows = totalRows;
    }

}
