package com.jsp.ex.command;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsp.ex.dao.BDao;
import com.jsp.ex.dto.BDto;

public class BReplyCommand implements BCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("==== ENTER BReplyCommand ====");
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
		
		String bName = request.getParameter("bName");
		String bTitle = request.getParameter("bTitle");
		String bContent = request.getParameter("bContent");
		Date bDate = new Date(System.currentTimeMillis());
		int bGroup = dto.getbGroup(); // 원글의 group 과 동일
		int bIndent = dto.getbIndent() + 1; // 원글의 indent 에서 depth + 1
		int bStep = dao.getRecentStep(bGroup, bIndent) + 1;
		boolean result = dao.write(bName, bTitle, bContent, bDate, bGroup, bStep, bIndent);
		request.setAttribute("writeStatus", result);
	}
}
