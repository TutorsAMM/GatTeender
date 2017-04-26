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
        <!--header contenente in titolo della pagina-->
        <c:set var="title" value="Bacheca Personale" scope="request"/>
        <jsp:include page="header.jsp"/>

        <!--Barra di navigazione tra le pagine del sito-->
        <c:set var="page" value="bacheca" scope="request"/>
        <jsp:include page="nav.jsp"/>

        <!--Contenuti della pagina-->
        <div id="divBody">
            <!--Informazioni personali-->
            <div id="info">
                <div class="profilePic">
                    <img title="fotoProfilo" alt="Foto Profilo" src="${gatto.urlFotoProfilo}">
                </div>
                <p id="catName">
                    <strong>Nome:</strong> 
                    ${gatto.nome}
                </p>
                <p id="catRace">
                    <strong>Razza:</strong> 
                    ${gatto.razza}
                </p>
                <p id="catContact">
                    <strong>eMail:</strong> 
                    ${gatto.email}
                </p>
                
                <c:if test="${empty param.user}">
                    <p id="logOutLink"><a href="Login?logout=1">Logout</a></p>
                </c:if>
                
            </div>

            <!--lista dei post-->
            <div id="posts">
                <c:forEach var="post" items="${posts}">
                    <div class="post">
                        <c:if test="${post.postType == 'TEXT'}">
                            <p>${post.content}</p>
                        </c:if>
                        <c:if test="${post.postType == 'IMAGE'}">
                            <img alt="Post con foto" src="${post.content}">
                        </c:if>
                    </div>
                </c:forEach>
            </div>
        </div>
    </body>
</html>
