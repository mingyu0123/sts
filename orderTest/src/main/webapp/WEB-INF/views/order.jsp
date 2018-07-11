<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
	<h2>주문정보</h2>
	<hr>
	<form action="order.do" method="post">
		고객명 : <input type="text" name="name">
		<input type="submit" value="검색">
	</form>
	<table border="1" width="80%">
		<tr>
			<td><a href="order.do?spcol=${id }">도서명</a></td>
			<td>출판사</td>
			<td>도서가격</td>
			<td>판매이익금</td>
			<td>주문일</td>
			<td>주소</td>
			<td>전화</td>
		</tr>
		<c:forEach var="o" items="${list }">
			<tr>
				<td>${o.bookname }</td>
				<td>${o.publisher }</td>
				<td>${o.price }</td>
				<td>${o.profit }</td>
				<td>${o.orderdate }</td>
				<td>${o.address }</td>
				<td>${o.phone }</td>
			</tr>
		</c:forEach>
	</table>
	
</body>
</html>