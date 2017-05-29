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
        <script src="js/jquery-3.2.1.min.js"></script>
        <script src="js/javascript.js"></script>
    </head>
    <body>
        <!--header contenente in titolo della pagina-->
        <c:set var="title" value="Cerca amici" scope="request"/>
        <jsp:include page="header.jsp"/>

        <!--Barra di navigazione tra le pagine del sito-->
        <c:set var="page" value="cercaamici" scope="request"/>
        <jsp:include page="nav.jsp"/>

        <!--Contenuti della pagina-->
        <div id="divBody">
            <div id="searchGato">
                <input id="searchField" type="text" placeholder="search your Gato!" value="">
                <button id="searchYourGato">Qui micio micio</button>
            </div>
            <div id="usersList">
                <c:forEach var="gatto" items="${gatti}">
                    <div class="user">
                        <div class="profilePic">
                            <img alt="Foto Profilo" src="${gatto.urlFotoProfilo}">
                        </div>
                        <div class="userData">
                            <h2>${gatto.nome}</h2>
                            <a href="index.html?user=${gatto.id}">Link al profilo</a>
                        </div>
                    </div>
                </c:forEach>
            </div>

        </div>
    </body>
</html>
