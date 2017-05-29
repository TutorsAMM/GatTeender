<%-- 
    Document   : listaGattiJson
    Created on : May 25, 2017, 3:10:17 PM
    Author     : F4briK
--%>

<%@page contentType="application/json" pageEncoding="UTF-8"%>
<%@ taglib prefix="json" uri="http://www.atg.com/taglibs/json" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<json:array>
    <c:forEach var="gatto" items="${listaGatti}">
        <json:object>
            <json:property name="nome" value="${gatto.nome}"/>
            <json:property name="razza" value="${gatto.razza}"/>
            <json:property name="id" value="${gatto.id}"/>
            <json:property name="email" value="${gatto.email}"/>
            <json:property name="password" value="${gatto.password}"/>
            <json:property name="urlFotoProfilo" value="${gatto.urlFotoProfilo}"/>
        </json:object>
    </c:forEach>
</json:array>
