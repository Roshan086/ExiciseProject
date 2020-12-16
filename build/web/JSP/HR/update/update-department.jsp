<%@ taglib uri="/struts-tags" prefix="s" %>  

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Edit Employee </title>
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
    </head>
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


            <div class="main">
                <!-- MAIN CONTENT -->
                <div class="main-content">
                    
                    <h4> Update Department </h4>
                    <hr>
                    <s:form theme="simple" action="updateDepartment">




                        <s:div cssClass="form-group">
                            <s:hidden name="id" value="%{id}" />
                            <s:label>Name</s:label>
                            <s:textfield name="name" cssClass="form-control" cssStyle="width:50%"></s:textfield>
                        </s:div>  
                        <s:div cssClass="form-group">
                            <s:submit value="Updae" method="updateDepartment" cssClass="btn btn-primary"> </s:submit>
                        </s:div>    
                    </s:form>
                        <div style="float:left; transform: translate(100px,-49.5px)">
                        <s:url id="cancelEdit" action="cancelEditDepartment">
                        </s:url>
                        <s:a href="%{cancelEdit}" cssClass="btn btn-danger">
                            <span class="badge badge-pill badge-danger">Cancel</span>
                        </s:a>
                    </div>
                </div>
            </div>
        </div>
        <div class="clearfix"></div>
        <jsp:include page="../../home/footer.jsp" />


        <!-- Javascript -->
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
