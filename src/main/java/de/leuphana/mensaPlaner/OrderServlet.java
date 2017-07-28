package de.leuphana.mensaPlaner;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import de.leuphana.webshop.shop.behaviour.Shop;
import de.leuphana.webshop.shop.structure.Cart;
import de.leuphana.webshop.shop.structure.CartItem;


@WebServlet("/orderArticle")
public class OrderServlet extends WebShopServlet{

    
    protected void printHeader(String titel){
    	out.println("<html>");
		out.println("<head>");
		out.println("<title>Cart</title>");
		out.println("</head>");
		out.println("<body>");

    	
    }
    
    protected void printBody(){
    	
		printCart();
		printOrderForm();
	
    	
    }
    

 
    private void printCart(){
    	
    	Cart cart = (Cart) request.getAttribute("cart");
    	
    	out.println("There are " + cart.getNumberOfArticles() + " Articles in cart.<br><br>"); //counter fehlt.... " + counter + "
		out.println("<table>");
		out.println("<tr>");
		out.println("<td><b>Quantity </td>");
		out.println("<td><b>Title </td>");
		out.println("<td><b>Price </td>");
		out.println("</tr>");
		
		for (CartItem cartItem : cart.getCartItems()) {
			
			out.println("<tr>");
			out.println("<td>" + cartItem.getQuantity() +"</td>");
			out.println("<td>" + cartItem.getArticle().getName() +"</td>");
			out.println("<td>" + cartItem.getArticle().getPrice() +"</td>");
			String urldeleteCartItem = "./dispatchAction?action=REMOVE_ARTICLE&articleId=" + cartItem.getArticle().getArticleId();
			out.println("<td><a href="+ urldeleteCartItem +">Remove article</a></td>");
			out.println("</tr>");
		}
		out.println("<tr>");
		out.println("<td></td>");
		out.println("<td>Total Price: " + cart.getTotalPrice() + "</td>");;
		out.println("</tr>");
		out.println("</table>");

    	
    }
    
    private void printOrderForm(){
    	out.println("The following information is needed for ordering:<br><br>");
    	
    
    	out.println("<form action=\"./showReceipt\" method=\"post\">");
    	out.println("Name: ");
    	out.println("<input type=\"text\" name=\"name\">"); 
   
    	out.println("Credit Cart Number: ");
    	out.println("<input type=\"text\" name=\"creditcard\">");
    	out.println("<input type=\"submit\">");  
    	out.println("</form>");
 
    	
    }
}

