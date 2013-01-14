<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>

<html>
    <head>
        <title>Planetary System - Add Planet</title>
        <meta http-equiv="content-type" content="text/html; charset=iso-8859-1" />
        <script src="//ajax.googleapis.com/ajax/libs/jquery/1.8.0/jquery.min.js" type="text/javascript"></script>
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

                    <h2>Add New Planet</h2>
                    <div id="box">  

                        <form  method="post" action="addPlanet.htm" class="well">
                            <fieldset>
                                <legend> Enter New Planet</legend> </br>
                                <label>Planet name: </label>
                                <input type="text" name="description" /><br /> 
                                <label>Distance From The Sun</label>
                                <input type="text" name="distanceFromTheSun"  /><br />
                                <label>Planet Mass</label>
                                <input type="text" name="planetMass"  /><br />


                                <input class="btn" type="reset" />
                                <input class="btn btn-primary" type="submit" />
                            </fieldset>
                        </form> 


                    </div>

                </div>

                <div id="page_footer">
                    <p>Marcin Chojnowski</p>
                    <p class="smaller">&copy; Copyright 2013. All Rights Reserved</p>
                </div>
            </div><!-- page container -->
            <script>
                function isNumber(n) {
                    return !isNaN(parseFloat(n)) && isFinite(n);
                }
                $(document).ready(function(){
                    $('form').submit(function(e){                        
                        var distance = $('input[name="distanceFromTheSun"]').val();
                        var mass = $('input[name="planetMass"]').val();
                        if(!isNumber(distance)){
                            alert('Distance From the Sun  must be a number - use "." if needed')
                             return false;                  
                        } else if(!isNumber(mass)){                           
                            alert('Planet Mass must be a number - use "." if needed');
                            return false; 
                        }
                        else {
                            return true;
                        }
                        
                    })
                })
                           
            </script>
           
    </body>
</html>