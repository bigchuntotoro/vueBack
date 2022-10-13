<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
  table {
    width: 100%;
    border: 1px solid #444444;
  }
  th, td {
    border: 1px solid #444444;
  }
</style>
</head>
<body>
<h2>${name}님 반갑습니다!</span></h2>
<hr>
<table>
	<c:forEach var="data" items="${result}">
		<tr>
			<td>${data.id}</td>
			<td>${data.name }</td>
			<td>${data.price }</td>
			<td>${data.createdDate }</td>
		</tr>
	</c:forEach>
</table>
</body>
</html>