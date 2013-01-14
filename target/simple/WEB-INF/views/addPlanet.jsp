<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<html>
    <head>
        <title>Planetary System - Planets List</title>
        <meta http-equiv="content-type" content="text/html; charset=iso-8859-1" />
        <link rel="stylesheet" href="static/css/style.css" type="text/css">

    </head>
    <body>
        <div id="page_container">
            <div id="header" >
                <h1>Solar System</h1>
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

                    <h2>Add New Planet</h2>
                    <div id="box">      	
                        <form id="memberform" method="post" action="addPlanet.htm">

                            <legend> Enter New Planet</legend> </br>
                                <label>Planet name: </label>
                                <input type="text" name="description" /><br />

                                <input class="button1" type="reset" />
                                <input class="button1" type="submit" />

                        </form> 
                       
                    </div>

                </div>

                <div id="page_footer">
                    <p>Marcin Chojnowski</p>
                    <p class="smaller">&copy; Copyright 2013. All Rights Reserved</p>
                </div>
            </div><!-- page container -->

    </body>
</html>