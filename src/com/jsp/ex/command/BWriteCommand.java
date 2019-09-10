package com.jsp.ex.command;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsp.ex.dao.BDao;

public class BWriteCommand implements BCommand {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("==== ENTER BWriteCommand ====");
		BDao dao = BDao.getInstance();
		String bName = request.getParameter("bName");
		String bTitle = request.getParameter("bTitle");
		String bContent = request.getParameter("bContent");
		Date bDate = new Date(System.currentTimeMillis());
		int bGroup = dao.getMaxGroup() + 1; // 최상위 게시글 단계 ROOT
		try {
//			int bStep = Integer.parseInt(request.getParameter("bStep")); // leaf 순서
//			int bIndent = Integer.parseInt(request.getParameter("bIndent")); // depth  	
		} catch(Exception e) {
			e.printStackTrace();
			response.sendError(400, "잘못된 요청입니다.");
		}
		boolean result = dao.write(bName, bTitle, bContent, bDate, bGroup, 1, 1);
		request.setAttribute("writeStatus", result);
	}
}
