<%@ page language="java" contentType="application/json; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:url var="url" value="http://openapi.nsdi.go.kr/nsdi/eios/service/rest/AdmService/admSiList.json">
  <c:param name="authkey" value="${param.authkey}"/>
  <c:param name="admCode" value="${param.admCode}"/>
</c:url>
<c:import url="${url}"/>
