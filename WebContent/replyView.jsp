<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="EUC-KR">
		<title>게시판 | 답글 작성</title>
		<style>
			.wrapper {
				max-width: 700px;
				margin:auto;
				padding:16px;
			}
			.form-group{
				margin-bottom:0px !important;
			}
		</style>
		<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
	</head>
<body>
	<div class="wrapper">
		<h2> 답글 작성 - ${originPost.bTitle} </h2>
		<form action="/reply.do?post=${originPost.bId}" method="post" style="margin-top:30px;">
			<table class="table">
				<tbody>
					<tr>
						<th width="30%">작성자</th>
						<td width="70%">
						    <div class="form-group">
								<input class="form-control" name="bName" type="text" placeholder="작성자 이름" required>
						    </div>
						</td>
					</tr>
					<tr>
						<th> 제목 </th>
						<td>
						    <div class="form-group">
								<input type="text" name="bTitle" class="form-control" placeholder="제목" required>
						    </div>
						</td>
					</tr>
					<tr>
						<th> 내용 </th>
						<td>
						    <div class="form-group">
						    	<textarea class="form-control" placeholder="내용 입력" name="bContent" required style="resize:none; width:100%; padding:10px; height:300px;"></textarea>
						    </div>
						</td>
					</tr>
				</tbody>
				<tr>
					<td colspan="2" style="text-align:center;">
						<input class="btn btn-success" type="submit" value="작성" style="margin-right:10px;">
						<a class="btn btn-secondary" href="/list.do">목록</a>
					</td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>