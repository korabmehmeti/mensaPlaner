package de.leuphana.mensaPlaner;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import de.leuphana.webshop.shop.behaviour.Shop;
import de.leuphana.webshop.shop.structure.Cart;
import de.leuphana.webshop.shop.structure.CartItem;


@WebServlet("/showReceipt")
public class ReceiptServlet extends WebShopServlet {

	
	protected void printHeader(String titel){
		

	}
	
	protected void printBody(){
		
		
	}
	

}
