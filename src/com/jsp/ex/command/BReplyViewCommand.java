package com.jsp.ex.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsp.ex.dao.BDao;
import com.jsp.ex.dto.BDto;

public class BReplyViewCommand implements BCommand {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("==== ENTER BReplyViewCommand ====");
		Integer originBId = null;
		BDto dto = null;
		BDao dao = BDao.getInstance();
		try {
			originBId = Integer.parseInt(request.getParameter("post"));
		} catch (Exception e) {
			e.printStackTrace();
			response.sendError(400, "잘못된 접근입니다.");
		}
		if (originBId != null) dto = dao.content(originBId);
		request.setAttribute("originPost", dto);
	}
}
