<%-- 
    Document   : header
    Created on : 10-apr-2017, 11.31.36
    Author     : Tutor_IUM
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<nav>
    <ol>
        <li <c:if test="${page=='bacheca'}">class="active"</c:if>><a href="Bacheca">Bacheca Personale</a></li>
        <li <c:if test="${page=='nuovopost'}">class="active"</c:if>><a href="NuovoPost">Nuovo Post Personale</a></li>
        <li <c:if test="${page=='cercaamici'}">class="active"</c:if>><a href="CercaAmici">Cerca aMici</a></li>
        <li <c:if test="${page=='amicidelcuore'}">class="active"</c:if>><a href="amicidelcuore.html">aMici del ❤</a></li>
        <li <c:if test="${page=='razdegat'}">class="active"</c:if>><a href="razdegat.html">Razze di gatti</a></li>
    </ol>
</nav>
