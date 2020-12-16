<%@ taglib uri="/struts-tags" prefix="s" %>  

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div id="departmentTable"> 

    <s:div cssClass="form-group">
        <s:hidden name="totalRows" cssClass="form-control" cssStyle="width:50%" id="totalRows"></s:hidden>
    </s:div>


    <table id="rankings-table"  class="table table-hover" style="width: 100%; ">
        <thead>
            <tr>
                <th scope="col">ID</th>
                <th scope="col">Name</th>
                <th scope="col"></th>
                <th scope="col"></th>
            </tr>
        </thead>
        <tbody>
            <s:iterator value="departments">
                <tr>
                    <td > <s:property  value="id" /> </td> 
                    <td > <s:property value="name" /> </td>
                    <td class="text-left">
                        <s:url id="deleteURL" action="deleteDepartment">
                            <s:param name="id" value="%{id}" ></s:param>
                        </s:url>
                        <s:a href="%{deleteURL}" >Delete</s:a>
                        </td>

                        <td>
                        <s:url id="editURL" action="editDepartment">
                            <s:param name="id" value="%{id}"></s:param>
                            <s:param name="name" value="%{name}"></s:param>
                        </s:url>
                        <s:a href="%{editURL}">Edit</s:a>
                        </td>  
                    </tr>
            </s:iterator>
        </tbody>
    </table>
</div>

