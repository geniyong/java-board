<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="EUC-KR">
		<title>�Խ��� | ���</title>
		<style>
			.wrapper {
				max-width: 700px;
				margin:auto;
				padding:16px;
			}
		</style>
		<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
	</head>
	<body>
		<div class="wrapper">
			<h2>�Խ���</h2>
			<table class="table table-hover table-striped" style="margin-top:30px;">
				<thead>
					<tr>
						<th> ��ȣ </th>
						<th> �ۼ��� </th>
						<th> ���� </th>
						<th> �ۼ��� </th>
						<th> ��ȸ�� </th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${list}" var="dto">
						<tr onclick="window.location='/contentview.do?post=${dto.bId}';">
							<th> ${dto.bId} </th>
							<td> ${dto.bName} </td>
							<td> <c:forEach begin="3" end="${dto.bIndent}">&nbsp&nbsp</c:forEach><c:if test="${dto.bIndent > 1}">��</c:if>${dto.bTitle} </td>
							<td> ${dto.bDate} </td>
							<td> ${dto.bHit} </td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			<p style="text-align:right;"> <a class="btn btn-primary" href="/writeview.do"> ���ۼ� </a> </p>
		</div>
	</body>
</html>