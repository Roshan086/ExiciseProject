<%@ taglib uri="/struts-tags" prefix="s" %>  

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <!-- VENDOR CSS -->
	<link rel="stylesheet" href="assets/vendor/bootstrap/css/bootstrap.min.css">
	<link rel="stylesheet" href="assets/vendor/font-awesome/css/font-awesome.min.css">
	<link rel="stylesheet" href="assets/vendor/linearicons/style.css">
	<link rel="stylesheet" href="assets/vendor/chartist/css/chartist-custom.css">
	<!-- MAIN CSS -->
	<link rel="stylesheet" href="assets/css/main.css">
	<!-- FOR DEMO PURPOSES ONLY. You should remove this in your project -->
	<link rel="stylesheet" href="assets/css/demo.css">
	<!-- GOOGLE FONTS -->
	<link href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,600,700" rel="stylesheet">
	<!-- ICONS -->
	<link rel="apple-touch-icon" sizes="76x76" href="assets/img/apple-icon.png">
	<link rel="icon" type="image/png" sizes="96x96" href="assets/img/favicon.png">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        
	<script src="assets/scripts/employee-pagination.js"></script>
        
    <style>
        #page-btn
        {
            padding: 8px;
            border-color: whitesmoke;
            background: none;
            font-weight: bold;
            color: red;
        }
        
        #pagination-controls .btn{
            background: none;
            font-weight: bold;
        }
    </style>
    </head>
    
    
    <body>
        
	<!-- WRAPPER -->
	<div id="wrapper">
		<!-- NAVBAR -->
		
                <jsp:include page="../home/header.jsp" />
                
                <!-- END NAVBAR -->
		<!-- LEFT SIDEBAR -->
                
                <jsp:include page="../home/sidebar.jsp" />
		<!-- END LEFT SIDEBAR -->
		<!-- MAIN -->
                <div class="main container-fluid">
                <br>
                
                <div style="float:right">
                    <s:url id="addEmployee" action="addEmployee">
                    </s:url>
                    <s:a href="%{addEmployee}" cssClass="btn btn-success btn">
                        <span class="glyphicon glyphicon-plus"></span> Add Employee
                    </s:a>
                </div>
                <div class="form-group">
                    <label>Rows</label>
                    <select class="form-control" id="entries" style="width:25%">
                        <option value="3"> 3 </option>
                        <option value="5" selected=""> 5 </option>
                        <option value="10"> 10 </option>
                        <option value="15"> 15 </option>
                        <option value="20"> 20 </option>
                    </select>
                </div>
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
                <th> EDIT </th>
                <th> DELETE </th>
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
                        </tr>
                    </s:iterator>
                </tbody>
            </table>
            </div>
            
            <div id="pagination-controls" style="text-align: center;">
                <button id="first-btn" class="btn"> First </button>
                <button id="previous-btn" class="btn"> <span class="glyphicon glyphicon-backward"> </span>  </button>
                    <span id="pagination-buttons"></span>
                <button id="next-btn" class="btn"> <span class="glyphicon glyphicon-forward"> </span> </button>

                <button id="last-btn" class="btn"> Last </button>
            </div>
            
        </div>
        </div> 
        
        <div class="clearfix"></div>
        <jsp:include page="../home/footer.jsp" />
<!--        
        <script src="../../assets/scripts/employee-pagination.js"></script>
        -->
	<!-- Javascript -->
        <script src="assets/vendor/jquery/jquery.min.js"></script>
        <script src="assets/vendor/jquery/jquery.min.js"></script>
	<script src="assets/vendor/jquery/jquery.min.js"></script>
	<script src="assets/vendor/bootstrap/js/bootstrap.min.js"></script>
	<script src="assets/vendor/jquery-slimscroll/jquery.slimscroll.min.js"></script>
	<script src="assets/vendor/jquery.easy-pie-chart/jquery.easypiechart.min.js"></script>
	<script src="assets/vendor/chartist/js/chartist.min.js"></script>
	<script src="assets/scripts/klorofil-common.js"></script>
	<script>
    </body>
</html>
