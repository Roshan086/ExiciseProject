package com.exices.taxation.transformer;

import com.exices.taxation.dao.EmployeeDAO;
import com.exices.taxation.daoImpl.EmployeeDAOImpl;
import com.exices.taxation.dto.DepartmentDTO;
import com.exices.taxation.dto.EmployeeDTO;
import com.exices.taxation.models.DepartmentModel;
import com.exices.taxation.models.EmployeeModel;
import java.util.ArrayList;
import java.util.List;


public class EmployeeTransformer 
{
    
    public static List<EmployeeDTO> getAllEmployees(){
        
        List<EmployeeDTO> employees = new ArrayList<EmployeeDTO>();
        EmployeeDAO employeeDAO = new EmployeeDAOImpl();
        List<EmployeeModel> employeesList =employeeDAO.getAllEmployee();
        for(EmployeeModel employeeModel : employeesList )
        {
            
            //DepartmentDTO departmentDTO = new DepartmentDTO();
            //EmployeeDTO employeeDTO = new EmployeeDTO();
            //System.out.println("Name : "+ employeeModel.getName());
            //employeeDTO.setId(employeeModel.getId().toString());
            //employeeDTO.setName(employeeModel.getName());
            //employeeDTO.setGender(employeeModel.getGender());
            //employeeDTO.setEmail(employeeModel.getEmail());
            
            //departmentDTO.setName(employeeModel.getDepartmentModel().getName());
            //departmentDTO.setId(employeeModel.getDepartmentModel().getId().toString());
            
            //employeeDTO.setDepartmentDTO(departmentDTO);
            
            employees.add(EmployeeTransformer.getEmployeeDTOByEmployeeModel(employeeModel));
        }        
        return employees;
    }
    
    public static List<EmployeeDTO> getAllEmployeesByRows(Integer firstValue, Integer noOfRows) {
        
        List<EmployeeDTO> employees = new ArrayList<>();
        EmployeeDAO employeeDAO = new EmployeeDAOImpl();
        List<EmployeeModel> employeesList =employeeDAO.getAllEmployeesByRows(firstValue, noOfRows);
        for(EmployeeModel employeeModel : employeesList )
        {
            
//            DepartmentDTO departmentDTO = new DepartmentDTO();
//            EmployeeDTO employeeDTO = new EmployeeDTO();
//            employeeDTO.setId(employeeModel.getId().toString());
//            employeeDTO.setName(employeeModel.getName());
//            employeeDTO.setGender(employeeModel.getGender());
//            employeeDTO.setEmail(employeeModel.getEmail());
//            departmentDTO.setName(employeeModel.getDepartmentModel().getName());
//            departmentDTO.setId(employeeModel.getDepartmentModel().getId().toString());
//            
//            employeeDTO.setDepartmentDTO(departmentDTO);
//            
            employees.add(EmployeeTransformer.getEmployeeDTOByEmployeeModel(employeeModel));
       
        }        
        return employees;
    }
    
    
    public static void saveEmployee(EmployeeDTO employeeDTO){
        EmployeeDAO employeeDAO = new EmployeeDAOImpl();
        
        EmployeeModel employeeModel = new EmployeeModel();
        DepartmentModel departmentModel =new DepartmentModel();
        
        employeeModel.setName(employeeDTO.getName());
        employeeModel.setEmail(employeeDTO.getEmail());
        employeeModel.setGender(employeeDTO.getGender());
        departmentModel.setId(Integer.parseInt(employeeDTO.getDepartmentDTO().getId()));
        employeeModel.setDepartmentModel(departmentModel);
        
        employeeDAO.createEmployee(employeeModel);
    }
    
    public static void deleteEmployee(EmployeeDTO employeeDTO){
        EmployeeDAO employeeDAO = new EmployeeDAOImpl();
        
        EmployeeModel employeeModel = new EmployeeModel();
        employeeModel.setId(Integer.parseInt(employeeDTO.getId()));
        
        employeeDAO.deleteEmployee(employeeModel);    
    }
    
    public static void updateEmployee(EmployeeDTO employeeDTO)
    {
        EmployeeDAO employeeDAO = new EmployeeDAOImpl();
        
        EmployeeModel employeeModel = new EmployeeModel();
        DepartmentModel departmentModel =new DepartmentModel();
        
        employeeModel.setId(Integer.parseInt(employeeDTO.getId()));
        employeeModel.setName(employeeDTO.getName());
        employeeModel.setEmail(employeeDTO.getEmail());
        employeeModel.setGender(employeeDTO.getGender());
        departmentModel.setId(Integer.parseInt(employeeDTO.getDepartmentDTO().getId()));
        employeeModel.setDepartmentModel(departmentModel);
        
        employeeDAO.updateEmployee(employeeModel);
        
    }
    
    public static EmployeeDTO getEmployeeByEmployeeId(Integer employeeId)
    {
        EmployeeDAO employeeDAO = new EmployeeDAOImpl();
        EmployeeModel employeeModel = employeeDAO.getEmployeeByEmployeeId(employeeId);
        
        EmployeeDTO employeeDTO = new EmployeeDTO();
        DepartmentDTO departmentDTO = new DepartmentDTO();
        
        employeeDTO.setId(employeeModel.getId().toString());
        employeeDTO.setName(employeeModel.getName());
        employeeDTO.setEmail(employeeModel.getEmail());
        employeeDTO.setGender(employeeModel.getGender());
        
        departmentDTO.setId(employeeModel.getDepartmentModel().getId().toString());
        departmentDTO.setName((employeeModel.getDepartmentModel().getName()));
        employeeDTO.setDepartmentDTO(departmentDTO);
        
        return employeeDTO;
    }
    
    public static EmployeeModel getEmployeeModelByEmployeeDTO(EmployeeDTO employeeDTO){
        EmployeeModel employeeModel=new EmployeeModel();
            if(employeeDTO.getId()!=null){
                employeeModel.setId(Integer.parseInt(employeeDTO.getId()));
            }
        return employeeModel;
    }
    
    public static EmployeeDTO getEmployeeDTOByEmployeeModel(EmployeeModel employeeModel){
        EmployeeDTO employeeDTO=new EmployeeDTO();
        if(employeeModel.getId()!=null)
            employeeDTO.setId(employeeModel.getId().toString());
        
        if(employeeModel.getName()!=null)
            employeeDTO.setName(employeeModel.getName());
        
        if(employeeModel.getEmail()!=null)
            employeeDTO.setEmail(employeeModel.getEmail());
        
        if(employeeModel.getGender()!=null)
            employeeDTO.setGender(employeeModel.getGender());
        
        if(employeeModel.getDepartmentModel()!=null)
            employeeDTO.setDepartmentDTO(DepartmentTransformer.getDepartmentDTOByDepartentModel(employeeModel.getDepartmentModel()));
        
        return employeeDTO;
    }
    
    public static Integer getTableSize(){
        EmployeeDAO employeeDAO = new EmployeeDAOImpl();
        return employeeDAO.getTableSize();
    }
    

}
