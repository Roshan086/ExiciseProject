<%@ taglib uri="/struts-tags" prefix="s" %>  
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
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

        <!--<script src="assets/scripts/department-pagination.js"></script>-->

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

            <jsp:include page="../../home/header.jsp" />

            <!-- END NAVBAR -->
            <!-- LEFT SIDEBAR -->

            <jsp:include page="../../home/sidebar.jsp" />
            <!-- END LEFT SIDEBAR -->
            <!-- MAIN -->

            <div class="main container-fluid">
                <br>
                <%--<s:textfield name="name" cssClass="form-control" cssStyle="width:50%" id="text"></s:textfield>--%>
                <div style="float:left; margin-top: 20px;">
                    <div class="form-group">

                        <label>Select Location</label>
                        <select class="form-control" id="entries" style="width:25%">
                            <option value="District" selected=""> District </option>
                            <option value="District"> District </option>
                            <option value="Taluka"> taluka </option>
                            <option value="UC"> UC </option>
                        </select>
                    </div>
                </div>

                <div id="district" style="margin-left: 50px;">
                    <hr>
                    <s:form theme="simple" action="addDistrict">
                        <s:div cssClass="form-group">
                            <s:label>District</s:label>
                            <s:textfield name="locationName" cssClass="form-control" cssStyle="width:50%"></s:textfield>
                        </s:div>
                        <s:div cssClass="form-group" cssStyle="margin-left: 50px;">
                            <s:submit value="Add District" method="addDistrict" cssClass="btn btn-primary"> </s:submit>
                        </s:div>    
                    </s:form>
                </div> 
                <div id="taluka" style="margin-left: 50px;">
                    <hr>
                    <s:form theme="simple" action="addDistrict">
                        <s:div cssClass="form-group">
                            
                            <s:select 
                                  list="districtLocations"
                            headerKey="-1" headerValue="Select District"
                            listKey="id"
                            listValue="locationName"
                            name="location" 
                            cssClass="form-control"
                            cssStyle="width:50%"
                                      />
                        </s:div>
                        <s:div cssClass="form-group">
                            <s:label>Taluka</s:label>
                            <s:textfield name="locationName" cssClass="form-control" cssStyle="width:50%; margin-left: 50px; "></s:textfield>
                        </s:div>
                        <s:div cssClass="form-group" cssStyle="margin-left: 50px;">
                            <s:submit value="Add Taluka" method="addTaluka" cssClass="btn btn-primary"> </s:submit>
                        </s:div>    
                    </s:form>

                </div> 



            </div>
        </div> 

        <div class="clearfix"></div>
        <jsp:include page="../../home/footer.jsp" />
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
        <script >


            $(document).ready(function () {
                $('#district').hide();
                $('#taluka').hide();
                $("#entries ").change(function () {

                    var location = $("#entries ").val()
                    if (location == 'District') {
                        $('#taluka').hide();
                        $('#district').show();
                    } else if (location = 'Taluka') {
                        $('#district').hide();
                        $('#taluka').show();

                    }
                });

            });
        </script> 
    </body>
</html>
