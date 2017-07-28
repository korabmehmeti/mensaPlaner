package de.leuphana.mensaPlaner;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/BannerServlet")
public class BannerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private PrintWriter out;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		out = response.getWriter();
		printBanner();
	
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		out = response.getWriter();
		doGet(request, response);
	}
	
	private void printBanner(){
		out.println("<html>");
		out.println("<head>");

		out.println("<h1>ONLINE-WEBSHOP</h1>");
		out.println("</head>");
		out.println("</html>");

	}

}
