<%@ taglib uri="/struts-tags" prefix="s" %>  

<%@page contentType="text/html" pageEncoding="UTF-8"%>
        <div id="employeeTable">    

        <s:div cssClass="form-group">
            <s:hidden name="totalRows" cssClass="form-control" cssStyle="width:50%" id="totalRows"></s:hidden>
        </s:div>


        <table class="table table-responsive" id="paginate">
        <tr>
        <th> Employee ID </th>
        <th> Name </th>
        <th> Gender </th>
        <th> Email </th>
        <th> Department </th>
        <th>  </th>
        <th> ACTION </th>
        <th>  </th>
        </tr>
        <tbody>
            <s:iterator  value="employees"> 
                <tr>
                    <td> <s:property value="id"/> </td>
                    <td> <s:property value="name"/> </td>
                    <td> <s:property value="gender"/> </td>
                    <td> <s:property value="email"/> </td>
                    <td> <s:property value="departmentDTO.name"/> </td>
                    <td>
                    <s:url id="editEmployeeForm" action="editEmployeeForm">
                        <s:param name="id" value="%{id}"></s:param>
                        </s:url>
                        <s:a href="%{editEmployeeForm}" cssClass="btn btn-primary btn">
                            <span class="glyphicon glyphicon-edit"></span> 
                        </s:a>
                    </td>
                    <td>
                        <s:url id="deleteEmployee" action="deleteEmployee">
                        <s:param name="id" value="%{id}"></s:param>
                        </s:url>
                        <s:a href="%{deleteEmployee}" cssClass="btn btn-danger btn">
                            <span class="glyphicon glyphicon-trash"></span> 
                        </s:a>
                    </td>

                    <td>
                        <s:url id="addEmployee" action="addEmployee">
                        </s:url>
                        <s:a href="%{addEmployee}" cssClass="btn btn-success btn">
                            <span class="glyphicon glyphicon-plus"></span> 
                        </s:a>
                    </td>
                </tr>
            </s:iterator>
        </tbody>
    </table>
    </div>
            
