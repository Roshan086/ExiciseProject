<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>

<div id="sidebar-nav" class="sidebar">
    <div class="sidebar-scroll">
        <nav>
            <ul class="nav">
                <li><a href="index.html" class="active"><i class="lnr lnr-home"></i> <span>Dashboard</span></a></li>
                <li>
                    <a href="#subPages" data-toggle="collapse" class="collapsed"><i class="lnr lnr-file-empty"></i> <span>HR</span> <i class="icon-submenu lnr lnr-chevron-left"></i></a>
                    <div id="subPages" class="collapse ">
                        <ul class="nav">
                            <li>
                                <s:url action="departments" var="departments"/>       
                                <s:a class="nav-link" href="%{departments}">Department</s:a>
                            </li>
                            <li>
                                <s:url action="employees" var="employees"/>       
                                <s:a class="nav-link" href="%{employees}">Employees</s:a>
                            </li>

                            <li>
                                <s:url action="locations" var="locations"/>       
                                <s:a class="nav-link" href="%{locations}">Location</s:a>
                            </li>
                        </ul>
                    </div>
                </li>
            </ul>
        </nav>
    </div>
</div>
