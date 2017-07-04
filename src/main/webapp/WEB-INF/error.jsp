<%@page import="java.io.PrintWriter"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
  <meta charset='UTF-8'>
  <title>강사 관리</title>
  <jsp:include page="../corestyle.jsp"></jsp:include>
</head>
<body>
<jsp:include page="../header.jsp"></jsp:include>
<h1>오류 발생 by JSP</h1>
<pre>
<%
Exception e = (Exception)request.getAttribute("error");
if (e != null) {
  e.printStackTrace(new PrintWriter(out));
}
%>
</pre>
<jsp:include page="../footer.jsp"></jsp:include>
</body>
</html>
