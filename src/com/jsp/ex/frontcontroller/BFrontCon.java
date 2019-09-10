package com.jsp.ex.frontcontroller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsp.ex.command.BCommand;
import com.jsp.ex.command.BContentCommand;
import com.jsp.ex.command.BListCommand;
import com.jsp.ex.command.BWriteCommand;

/**
 * Servlet implementation class BFrontCon
 */
@WebServlet("*.do")
public class BFrontCon extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public BFrontCon() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		actionDo(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		actionDo(request, response);
	}
	
	protected void actionDo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("EUC-KR");
		response.setContentType("text/html;charset=EUC-KR");
		BCommand command = null;
		String uri = request.getRequestURI();
		String conPath = request.getContextPath();
		String com = uri.substring(conPath.length());
		
		if(com.equals("/list.do")) {
			command = new BListCommand();
			command.execute(request, response);
			request.getRequestDispatcher("list.jsp").forward(request, response);
		}
		
		else if(com.equals("/writeview.do")) {
			request.getRequestDispatcher("writeView.jsp").forward(request, response);
		}
		else if(com.equals("/write.do")) {
			command = new BWriteCommand();
			command.execute(request, response);
			response.sendRedirect("/list.do");
		}
		else if(com.equals("/contentview.do")) {
			command = new BContentCommand();
			command.execute(request, response);
			request.getRequestDispatcher("contentView.jsp").forward(request, response);
		}
	}	
}
