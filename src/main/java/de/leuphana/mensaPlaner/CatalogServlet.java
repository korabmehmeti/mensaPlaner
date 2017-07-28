package de.leuphana.mensaPlaner;

import java.io.PrintWriter;
import java.util.Set;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import de.leuphana.webshop.shop.behaviour.Shop;
import de.leuphana.webshop.shop.structure.Article;
import de.leuphana.webshop.shop.structure.Book;


@WebServlet("/showCatalog33")
public class CatalogServlet extends WebShopServlet {


	protected void printHeader(String titel) {
		
	
	}
	
	
	protected void printBody(){
		
		
		Article article = (Article) request.getAttribute("article");
		
		String textUrl = request.getParameter("addAction");
		
		if(textUrl!=null){
			printAddedArticle(article);
		}
		
		printHeader("Catalog");
		printCatalog();
		printFooter();
			
	}
	
	
	private void printAddedArticle(Article article){
		
		out.println("<h3>You have added the following article into the cart: <br><br>");
		out.println(article.getName() + "<br><br>");
		out.println("<a href=./dispatchAction?action=SHOW_CART>Show cart</a></h3>");
		
	}
	
	private void printCatalog(){
		
		Shop onlineShop = Shop.create();
		
		Set<Article> catalog; 

		catalog = onlineShop.getArticles();
		String name = null;
		float price = 0;
		
		out.println("<table>");
		for (Article article : catalog) { 
			name = article.getName();
			price = article.getPrice();
			String urlArticleInfo = "./dispatchAction?action=SHOW_ARTICLE&articleId=" + article.getArticleId();
			String urlAddArticle = "./dispatchAction?action=ADD_ARTICLE&articleId=" + article.getArticleId();

			out.println("<tr>");
			out.println("<td><a href=" + urlArticleInfo + ">" + name + "</a></td>");
			out.println("<td>" + price + " Euro</td>");
			out.println("<td><a href=" + urlAddArticle + ">Add article</a></td>");
			out.println("</tr>");
		}
		out.println("</table>");
	
		
	}



}




