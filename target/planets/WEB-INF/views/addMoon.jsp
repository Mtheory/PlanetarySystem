<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<html>
    <head><title>Planetary System - addMoon</title>
        <meta http-equiv="content-type" content="text/html; charset=iso-8859-1" />
        <link href="//netdna.bootstrapcdn.com/twitter-bootstrap/2.2.2/css/bootstrap-combined.min.css" rel="stylesheet">
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
                    <li><a href="allMoons.htm">All Moons</a></li>
                    <li><a href="addPlanet.htm">Add Planets</a></li>
                    <li><a href="addMoon.htm">Add Moon</a></li>
                </ul>
            </div>
            <div id="page_content">
                <div id="content" >
                    <c:if test="${errors!=null}">
                        <div class="alert alert-error">Errors: <br/>${errors}</div>
                    </c:if>
                    <h2>Add New Moon</h2>
                    <div id="box">      	
                        <sf:form id="memberform" method="post" action="addMoon.htm" commandName="myMoon" cssClass="well">
                            <fieldset>
                                <legend>Please enter new Moon</legend> </br>
                                <label>Moon name: </label>
                                <sf:input path="name"  /><br />
                                <label>Select primary Planet:</label>
                                <sf:select path="planet" items="${allPlanets}" itemLabel="description" itemValue="id" cssClass="tu dodaj clase"></sf:select>
                                <br />
                                <input class="btn" type="reset" />
                                <input class="btn btn-primary" type="submit" />
                            </fieldset>
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