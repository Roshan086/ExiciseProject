package com.exices.taxation.transformer;

import com.exices.taxation.dao.DepartmentDAO;
import com.exices.taxation.daoImpl.DepartmentDAOImpl;
import com.exices.taxation.dto.DepartmentDTO;
import com.exices.taxation.models.DepartmentModel;
import java.util.ArrayList;
import java.util.List;

public class DepartmentTransformer {

    public static List<DepartmentDTO> getAllDepartments(List<DepartmentModel> departmentModels) {
        List<DepartmentDTO> departments = new ArrayList<>();
        
        for (DepartmentModel d : departmentModels) {
            System.out.println("DepartmentTransformer department >>>>> ///  " +d);
            departments.add(DepartmentTransformer.getDepartmentDTOByDepartentModel(d));
        }
        return departments;
    }

    /*public static void updateDepartment(DepartmentDTO departmentDTO) {
        DepartmentModel department = new DepartmentModel();
        department.setId(Integer.parseInt(departmentDTO.getId()));
        department.setName(departmentDTO.getName());
        DepartmentDAO departmentDao = new DepartmentDAOImpl();
        departmentDao.updateDepartment(department);
        System.out.println("Department Updated...");
    }

    public static void addDepartment(DepartmentDTO departmentDto) {
        DepartmentModel department = new DepartmentModel();
        DepartmentDAO departmentDao = new DepartmentDAOImpl();
        department.setName(departmentDto.getName());
        departmentDao.createDepartment(department);

    }

    public static void deleteDepartment(int id) {
        DepartmentDAO departmentDAO = new DepartmentDAOImpl();
        DepartmentModel department = departmentDAO.getDepartmentByDepartmentId(id);
        departmentDAO.deleteDepartment(department);
    }

    public static List<DepartmentDTO> getDepartmentByPageAndRow(int pageSize, int noOfRow) {
        System.out.println("getDepartmentByPageAndRow() >>>> rows " + noOfRow);
        List<DepartmentDTO> departments = new ArrayList<DepartmentDTO>();
        DepartmentDAO dao = new DepartmentDAOImpl();
        List<DepartmentModel> departmentlist = dao.getAllEmployeesByRows(pageSize, noOfRow);
        for (DepartmentModel departmentModel : departmentlist) {
            DepartmentDTO departmentDto = new DepartmentDTO();
            departmentDto.setId(departmentModel.getId().toString());
            departmentDto.setName(departmentModel.getName());
            departments.add(departmentDto);
        }

        return departments;
    }*/
    
    public static DepartmentModel getDepartmentModelByDepartentDTO(DepartmentDTO departmentDTO){
        DepartmentModel departmentModel=new DepartmentModel();
            if(departmentDTO.getId()!=null){
                departmentModel.setId(Integer.parseInt(departmentDTO.getId()));
            }
            if(departmentDTO.getName()!=null){
                departmentModel.setName(departmentDTO.getName());
            }

        return departmentModel;
    }
    
    public static DepartmentDTO getDepartmentDTOByDepartentModel(DepartmentModel departmentModel){
        
        DepartmentDTO departmentDTO=new DepartmentDTO();
            if(departmentModel.getId()!=null){
                departmentDTO.setId(departmentModel.getId().toString());
            }
            if(departmentModel.getName()!=null){
                departmentDTO.setName(departmentModel.getName());
            }
        return departmentDTO;
    }

}
