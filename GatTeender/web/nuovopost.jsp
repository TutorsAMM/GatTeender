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
        <c:set var="title" value="Nuovo Post" scope="request"/>
        <jsp:include page="header.jsp"/>

        <!--Barra di navigazione tra le pagine del sito-->
        <c:set var="page" value="nuovopost" scope="request"/>
        <jsp:include page="nav.jsp"/>

        <!--Contenuti della pagina-->
        <div id="divBody">
            <c:choose>
                <c:when test="${empty newpost}">
                    <div id="formNewPost">
                        <form action="NuovoPost" method="post">
                            <div id="postType">
                                <div>
                                    <label for="textType">Post di Testo</label>
                                    <input type="radio" name="postType" value="textType" id="textType" checked="checked">
                                </div>
                                <div>
                                    <label for="imgType">Post con Foto</label>
                                    <input type="radio" name="postType" value="imgType" id="imgType">
                                </div>
                            </div>
                            <div id="postContent">
                                <div>
                                    <label for="textPost">Contenuto</label>
                                    <textarea name="textPost" id="textPost"></textarea>
                                </div>
                            </div>
                            <button type="submit" name="thereIsPost" value="needConfirm">Invia</button>
                        </form>     
                    </div>
                </c:when>
                <c:otherwise>
                    <div id="formNewPost">
                        <form action="NuovoPost" method="post">
                            <c:if test="${typePost == 'textType'}">
                                <p>${content}</p>
                            </c:if>
                            <c:if test="${typePost == 'imgType'}">
                                <img src="${content}" alt="downloadedImage">
                            </c:if>
                            <input type="text" hidden name="textPost" value="${content}">
                            <input type="text" hidden name="postType" value="${typePost}">
                            <button type="submit" name="thereIsPost" value="Confirmed">Conferma</button>
                        </form>
                    </div>
                </c:otherwise>
            </c:choose>
        </div>
    </body>
</html>
