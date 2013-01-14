<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>



<html
    <head>Planetary System - Moons List</title>
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


    </table>
    <div id="page_content">
        <div id="content" >
            <h3>List of Moons</h3>

            <c:choose>
                <c:when test="${fn:length(moons) gt 0}">
                    <table class="table" >

                        <tr>
                            <th>Moon Id</th>
                            <th>Moon Name</th>
                            <th>Planet Desc</th>
                            <th>Edit </th>
                        </tr>
                        <c:forEach var="moon" items="${moons}">
                            <tr>
                                <td><c:out value="${moon.id}"/></td>
                                <td>${moon.name}</td>
                                <td>${moon.planet.description}</td>
                                <td><a href="editMoon.htm?id=${moon.id}" >Edit</a></td>          
                            </tr>
                        </c:forEach>

                    </table>
                </c:when>
                <c:otherwise>No Moons</c:otherwise>
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