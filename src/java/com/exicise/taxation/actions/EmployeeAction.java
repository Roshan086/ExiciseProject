package com.exicise.taxation.actions;

import com.exices.taxation.dto.DepartmentDTO;
import com.exices.taxation.dto.EmployeeDTO;
import com.exices.taxation.transformer.DepartmentTransformer;
import com.exices.taxation.transformer.EmployeeTransformer;
import com.opensymphony.xwork2.ActionSupport;
import java.util.List;

public class EmployeeAction extends ActionSupport{
    private String id;
    private String name;
    private String email;
    private String gender;
    private String department;
    
    private Integer noOfRows = 5 ;
    private Integer firstValue = 0;
    private Integer totalRows;
    
    
    private DepartmentDTO departmentDTO;
    
    private List<EmployeeDTO> employees;
    
    private List<DepartmentDTO> departments;

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
 
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Integer getNoOfRows() {
        return noOfRows;
    }

    public void setNoOfRows(Integer noOfRows) {
        this.noOfRows = noOfRows;
    }

    public Integer getFirstValue() {
        return firstValue;
    }

    public void setFirstValue(Integer firstValue) {
        this.firstValue = firstValue;
    }

    public Integer getTotalRows() {
        return totalRows;
    }

    public void setTotalRows(Integer totalRows) {
        this.totalRows = totalRows;
    }
    
    public DepartmentDTO getDepartmentDTO() {
        return departmentDTO;
    }

    public void setDepartmentDTO(DepartmentDTO departmentDTO) {
        this.departmentDTO = departmentDTO;
    }
    
    
    public List<EmployeeDTO> getEmployees() {
        return employees;
    }

    public void setEmployees(List<EmployeeDTO> employees) {
        this.employees = employees;
    }

    public List<DepartmentDTO> getDepartments() {
        return departments;
    }

    public void setDepartments(List<DepartmentDTO> departments) {
        this.departments = departments;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return "EmployeeAction{" + "id=" + id + ", name=" + name + ", email=" + email + ", gender=" + gender + ", department=" + department + ", departmentDTO=" + departmentDTO + ", employees=" + employees + ", departments=" + departments + '}';
    }

    public String getAllEmployees(){
        System.out.println("In Method");
        System.out.println("Hello First Commit");
        employees = EmployeeTransformer.getAllEmployeesByRows(firstValue, noOfRows);
        for(EmployeeDTO e : employees)
            System.out.println("Action Dept:"+e.getDepartmentDTO().getName());
        totalRows = EmployeeTransformer.getAllEmployees().size();
        
        //System.out.println(noOfRows+"\t"+firstValue);
        
        return "success";
    }
    
    public String showAddEmployeeForm(){
        //departments = DepartmentTransformer.getAllDepartments();
        return "success";
    }
    
    public String saveEmployee(){
        
        EmployeeDTO employeeDTO = new EmployeeDTO();
        employeeDTO.setName(this.name);
        employeeDTO.setEmail(this.email);
        employeeDTO.setGender(this.gender);
        departmentDTO = new DepartmentDTO();
        departmentDTO.setId(this.department);
        employeeDTO.setDepartmentDTO(departmentDTO);
        
        EmployeeTransformer.saveEmployee(employeeDTO);
        
        employees = EmployeeTransformer.getAllEmployeesByRows(firstValue, noOfRows);
        totalRows = EmployeeTransformer.getAllEmployees().size();
        
        return "success";
    }

    public String deleteEmployee(){
        EmployeeDTO employeeDTO = new EmployeeDTO();
        employeeDTO.setId(this.id);
        
        EmployeeTransformer.deleteEmployee(employeeDTO);
        employees = EmployeeTransformer.getAllEmployeesByRows(firstValue, noOfRows);
        totalRows = EmployeeTransformer.getAllEmployees().size();
        
        
        System.out.println(noOfRows+"\t"+firstValue);
        
        
        return "success";
    }
    
    public String editEmployeeForm(){
        
        EmployeeDTO employeeDTO = EmployeeTransformer.getEmployeeByEmployeeId(Integer.parseInt(this.id));
        this.setId(employeeDTO.getId());
        this.setName(employeeDTO.getName());
        this.setEmail(employeeDTO.getEmail());
        this.setGender(employeeDTO.getGender());
        
        
        //departments = DepartmentTransformer.getAllDepartments();
        
        return "success";
    }
    
    public String editEmployee(){
        
        EmployeeDTO employeeDTO = new EmployeeDTO();
        employeeDTO.setId(this.id);
        employeeDTO.setName(this.name);
        employeeDTO.setEmail(this.email);
        employeeDTO.setGender(this.gender);
        departmentDTO = new DepartmentDTO();
        departmentDTO.setId(this.department);
        employeeDTO.setDepartmentDTO(departmentDTO);
        
        EmployeeTransformer.updateEmployee(employeeDTO);
        employees = EmployeeTransformer.getAllEmployeesByRows(firstValue, noOfRows);
        totalRows = EmployeeTransformer.getAllEmployees().size();
        
        
        return "success";
    }
    
}
