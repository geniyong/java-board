package com.jsp.ex.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsp.ex.dao.BDao;
import com.jsp.ex.dto.BDto;

public class BContentCommand implements BCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("==== ENTER BContentCommand ====");
		BDao dao = BDao.getInstance();
		Integer bId = null;
		try {
			bId = Integer.parseInt(request.getParameter("post"));
		} catch(Exception e) {
			e.printStackTrace();
			response.sendError(400, "잘못된 요청입니다.");
		}
		if(bId != null) {
			System.out.println(bId);
			BDto dto = dao.content(bId);
			System.out.println(dto.toString());
			request.setAttribute("post", dto);
		}
	}
}
