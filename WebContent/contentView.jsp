<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>게시판 | ${post.bTitle} </title>
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
			<h2>게시글 보기</h2>
			<table class="table" style="margin-top:30px;">
				<tbody>
					<tr>
						<th width="20%">글 번호</th>
						<td width="30%">
						    ${post.bId}
						</td>
						<th width="20%">조회 수</th>
						<td width="30%">
						    ${post.bHit}
						</td>
					</tr>
					<tr>
						<th> 제목 </th>
						<td colspan="3">
							${post.bTitle}
						</td>
					</tr>
					<tr height="200">
						<th> 내용 </th>
						<td colspan="3">
						    ${post.bContent}
						</td>
					</tr>
	 				<tr>
						<th>작성자</th>
						<td colspan="3">
						    ${post.bName}
						</td>
					</tr>
	 				<tr>
						<th>작성 날짜</th>
						<td colspan="3">
						    ${post.bDate}
						</td>
					</tr>
				</tbody>
			</table>
			<p style="text-align:center;">
				<a class="btn btn-secondary" href="/list.do" style="margin-right:10px;">목록</a>
				<a class="btn btn-success" href="/reply.do?post=${post.bId}" style="margin-right:10px;">답글 작성</a>
				<a class="btn btn-warning" href="/modify.do?post=${post.bId}" style="margin-right:10px;">수정</a>
				<a class="btn btn-danger" href="/delete.do?post=${post.bId}">삭제</a>
			</p>
		</div>
	</body>
</html>