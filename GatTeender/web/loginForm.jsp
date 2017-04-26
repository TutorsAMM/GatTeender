<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    <head>
        <title>GatTeender: trova il tuo gatto preferito</title>
        
        <meta charset="UTF-8">
        
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="author" content="Alessio Murru, Fabrizio Corda, Alessandro Carcangiu">
        <meta name="keywords" content="cerca gatti amore purr frr">
        
        <link rel="stylesheet" type="text/css" href="style.css" media="screen">
    </head>

    <body>
        <c:set var="title" value="Login" scope="request"/>
        <jsp:include page="header.jsp"/>
        
        <div id="divBody">
            <div id="formLogin">
                
                <c:if test="${invalidData == true}">
                    <div id="invalidDataWarning">I dati inseriti non sono corretti</div>
                </c:if>
                
                <form action="Login" method="post">
                    <div>
                        <label for="userName">UserName</label>
                        <input type="text" name="username" id="userName">
                    </div>
                    <div>
                        <label for="userPass">Password</label>
                        <input type="password" name="password" id="userPass">
                    </div>
                    <button type="submit">Invia</button>
                </form>
            </div>
        </div>
        
    </body>
</html>
