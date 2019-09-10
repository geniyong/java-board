<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="EUC-KR">
		<title>게시판 | 목록</title>
		<style>
			.wrapper {
				max-width: 700px;
				margin:auto;
				padding:16px;
			}
		</style>
		<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
	</head>
	<body>
		<div class="wrapper">
			<h2>게시판</h2>
			<table class="table table-hover table-striped" style="margin-top:30px;">
				<thead>
					<tr>
						<th> 번호 </th>
						<th> 작성자 </th>
						<th> 제목 </th>
						<th> 작성일 </th>
						<th> 조회수 </th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${list}" var="dto">
						<tr onclick="window.location='/contentview.do?post=${dto.bId}';">
							<th> ${dto.bId} </th>
							<td> ${dto.bName} </td>
							<td> ${dto.bTitle} </td>
							<td> ${dto.bDate} </td>
							<td> ${dto.bHit} </td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			<p style="text-align:right;"> <a class="btn btn-primary" href="/writeview.do"> 글작성 </a> </p>
		</div>
	</body>
</html>