package com.jsp.ex.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsp.ex.dao.BDao;

public class BDeleteCommand implements BCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("==== ENTER BDeleteCommand ====");
		Integer bId = null;
		BDao dao = BDao.getInstance();
		try {
			bId = Integer.parseInt(request.getParameter("post"));
		} catch (Exception e) {
			e.printStackTrace();
			response.sendError(400, "�߸��� �����Դϴ�.");
		}
		boolean result = dao.delete(bId);
		if(result == true) request.setAttribute("deleteStatus", result);
		else response.sendError(500, "�Խñ� ���� �� ���� �߻�");
	}
}
