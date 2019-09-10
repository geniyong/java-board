package com.jsp.ex.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsp.ex.dao.BDao;

public class BModifyCommand implements BCommand {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("==== ENTER BWriteCommand ====");
		BDao dao = BDao.getInstance();
		Integer bId = null;
		try {
			bId = Integer.parseInt(request.getParameter("bId"));
		} catch (Exception e) {
			e.printStackTrace();
			response.sendError(400, "잘못된 요청입니다.");
		}
		String bTitle = request.getParameter("bTitle");
		String bContent = request.getParameter("bContent");
		boolean result = dao.modify(bId, bTitle, bContent);
		if(result == true) request.setAttribute("writeStatus", result);
		else response.sendError(500, "게시글 수정 중 오류 발생");
	}
}
