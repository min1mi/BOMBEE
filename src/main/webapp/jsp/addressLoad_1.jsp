<%@ page language="java" contentType="application/json; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:url var="url" value="http://openapi.nsdi.go.kr/nsdi/eios/service/rest/AdmService/admCodeList.json">
  <c:param name="authkey" value="4c3dd139ed40e85475d902"/>
</c:url>
<c:import url="${url}"/>