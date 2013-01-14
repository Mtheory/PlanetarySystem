<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>


<html>
    <head><title>Planetary System - addMoon</title>
        <meta http-equiv="content-type" content="text/html; charset=iso-8859-1" />
        <link rel="stylesheet" href="static/css/style.css" type="text/css">
    </head>

    <body>
        <div id="page_container">
            <div id="header" >

                <p class="title" align="centre" ><h1>Solar System</h1>


            </div>  

            <div id="navigationBar">
                <ul id="menu">
                    <li><a href="index.jsp">Home</a></li>
                    <li><a href="allPlanets.htm">All Planets</a></li>
                    <li><a href="addPlanet.htm">Add Planets</a></li>
                    <li><a href="allMoons.htm">All Moons</a></li>
                    <li><a href="addMoon.htm">Add Moon</a></li>
                </ul>
            </div>

            <div id="page_content">
                <div id="content" >


                    <c:if test="${errors.errorCount gt 0}">
                        Errors!<br/>
                        <c:forEach var="error" items="${errors.allErrors}">
                            <span class="error">${error.objectName} ${error.code}</span>
                            <br />
                        </c:forEach>
                    </c:if>
                    <h2>Add New Moon</h2>
                    <div id="box">      	
                        <sf:form id="memberform" method="post" action="addMoon.htm" commandName="myMoon">

                            <legend>Please enter new Moon</legend> </br>
                            <label>Moon name: </label>
                            <sf:input path="name"  /><br />

                            <label>Select primary Planet:</label>
                            <sf:select path="planet" items="${allPlanets}" itemLabel="description" itemValue="id" cssClass="tu dodaj clase"></sf:select>
                                <br />

                                <input class="button1" type="reset" />
                                <input class="button1" type="submit" />
                        </sf:form>

                    </div>
                </div> <!-- page_content-->


                <div id="page_footer">
                    <p>Marcin Chojnowski</p>
                    <p class="smaller">&copy; Copyright 2013. All Rights Reserved</p>
                </div>
            </div><!-- page container -->
    </body>
</html>