package com.exices.taxation.dto;


public class EmployeeDTO extends GeneralDTO{
    private String id;
    private String name;
    private String email;
    private String gender;
    private DepartmentDTO departmentDTO;
    
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

    public DepartmentDTO getDepartmentDTO() {
        return departmentDTO;
    }

    public void setDepartmentDTO(DepartmentDTO departmentDTO) {
        this.departmentDTO = departmentDTO;
    }

    @Override
    public String toString() {
        return "EmployeeDTO{" + "id=" + id + ", name=" + name + ", email=" + email + ", gender=" + gender + ", departmentDTO=" + departmentDTO + '}';
    }
}
