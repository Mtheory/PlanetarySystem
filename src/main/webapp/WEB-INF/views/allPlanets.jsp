<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>



<html>
    <head><title>Planetary System - Planets List</title>
        <meta http-equiv="content-type" content="text/html; charset=utf-8" />
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
                    <h3>Planets</h3>

                    <c:choose>
                        <c:when test="${fn:length(planets) gt 0}">
                            <table class="table table-striped table-hover">
                                <tr>
                                    <th>Id</th>
                                    <th>Name</th>
                                    <th>Distance From The Sun</th>
                                    <th>Mass</th>
                                    <th>Moons</th>               
                                </tr>
                                <c:forEach var="planet" items="${planets}">
                                    <tr>
                                        <td><c:out value="${planet.id}"/></td>
                                        <td><c:out value="${planet.description}"/></td>
                                        <td><c:out value="${planet.distanceFromTheSun}"/></td>
                                        <td><c:out value="${planet.planetMass}"/></td>
                                        <td>
                                            <c:forEach var="moon" items="${moons}">
                                                <c:if test="${moon.planet.id==planet.id}">
                                                    <ul>
                                                        <li>
                                                            <a href="editMoon.htm?id=${moon.id}">${moon.name}</a>
                                                        </li>
                                                    </ul> 
                                                </c:if>     
                                            </c:forEach>
                                        </td>    

                                    </tr>
                                </c:forEach>
                            </table>
                        </c:when>
                        <c:otherwise>No Planets</c:otherwise>
                    </c:choose>

                </div>

            </div> <!-- page_content-->


            <div id="page_footer">
                <p>Marcin Chojnowski</p>
                <p class="smaller">&copy; Copyright 2013. All Rights Reserved</p>
            </div>
        </div><!-- page container -->
    </body>
</html>