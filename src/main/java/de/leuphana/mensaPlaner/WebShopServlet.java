package de.leuphana.mensaPlaner;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/WebShopServlet")
public abstract class WebShopServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected HttpServletRequest request;
	protected HttpServletResponse response;
	protected PrintWriter out; // prints text data to a character stream
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.request=request;
		this.response=response;
		response.setContentType("text/html");
		out = response.getWriter();  //Returns a PrintWriter object that can send character text to the client
			
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/BannerServlet");
		dispatcher.include(request, response);
		
		printBody();
		
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}
	
	private void printContent(){
		
	}

	protected void printHeader(String titel){
		out.println("<html>");
		out.println("<head>");
		out.println("<title>"+titel+"</title>");
		out.println();
		out.println("</head>");
		out.println("<body>");
		
		
	}
	
	protected abstract void printBody();
	
	
	protected void printFooter(){
		out.println("</body>");
		out.println("</html>");
		
	}

}
