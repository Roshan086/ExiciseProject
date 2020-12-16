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

        <script src="assets/scripts/department-pagination.js"></script>

    </head>

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
                    <s:url id="editDepartment" action="editDepartment">
                    </s:url>
                    <s:a href="%{editDepartment}" cssClass="btn btn-success btn">
                        <span class="glyphicon glyphicon-plus badge badge-pill">  Add Employee</span> 
                    </s:a>
                </div>
                <div class="form-group">
                    <label>Rows</label>
                    <select class="form-control" id="entries" style="width:25%">
                        <option value="5" selected=""> 5 </option>
                        <option value="10"> 10 </option>
                        <option value="15"> 15 </option>
                        <option value="20"> 20 </option>
                        <option value="25"> 25 </option>
                        <option value="30"> 30 </option>
                        <option value="30"> 35 </option>
                    </select>
                </div>
                <div id="departmentTable">    

                    <s:div cssClass="form-group">
                        <s:hidden name="totalRows" cssClass="form-control" cssStyle="width:50%" id="totalRows"></s:hidden>
                    </s:div>


                    <table id="rankings-table"  class="table table-hover" style="width: 100%; ">
                        <thead>
                            <tr>
                                <th scope="col">Serial No</th>
                                <th scope="col">Name</th>
                                <th scope="col"></th>
                                <th scope="col"></th>
                            </tr>
                        </thead>
                        <tbody>
                            <s:iterator value="departments"  status="incr">
                                <tr>

                                    <td > <s:property  value="%{#incr.index +1}" /> </td> 
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
