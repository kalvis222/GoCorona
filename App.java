package com.test;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;


public class App extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
String countryName= request.getParameter("countryName");
String url="https://www.worldometers.info/coronavirus/country/"+countryName;
PrintWriter out = response.getWriter();

out.println( "<html><head>"
		+ "<meta charset='ISO-8859-1'>"
+ " <title>Template Dashboard</title>"
   + "  <meta name='viewport' content='width=device-width, initial-scale=1'>"
 + "   <link rel='stylesheet' href='style.css'>"
+ "    <link rel='stylesheet' href='https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.12.1/css/all.min.css'>"
 + "  </head><body><input type='checkbox' id='check'>"
		
		
    + "<header>"
		+ "<label for='check'>"
		+ " <i class='fas fa-bars' id='sidebar_btn'></i>"
		+ "</label>"
+ "<div class='left_area'>"
+ "  <a href='template.html'><h2>Covid <span>19</span></h2></a>"
+ "</div>"
+ "<div class='right_area'>"
+ "  <a href='#' class='logout_btn'>Logout</a>"
+ "</div>"
+ "</header>"

+ "<div >"
+ "<div class='sidebar'>"
+ "<center>"
+ "  <img src='' class='' alt=''>"
 + " <h3 style='color:white'>Hrithik</h3>"
 + "</center><a href='dash.html'><i class='fas fa-desktop'></i><span>Dashboard</span></a>"
 + "<a href='symtoms.html' class='active'><i class='fas fa-cogs'></i><span>Symtoms</span></a>"
 + "<a href='Precautions.html'><i class='fas fa-table'></i><span>Precaution</span></a>"
 + "<a href='livecount.html'><i class='fas fa-th'></i><span>Live CaseCount</span></a>"
 + "<a href='Contact.html'><i class='fas fa-th'></i><span>ContactUs</span></a>"
 + "</div>");
out.println( "<center>"); 
out.println( "<div class='content' style='background-color:#c4e8fe','height: 100%'>"); 
out.println( "<h1>COVID-19 CORONAVIRUS PANDEMIC</h1>"); 
out.println( "<h3>Last updated:"+new Date()+"</h3>"); 

		Document doc= Jsoup.connect(url).get();
		Elements elements= doc.select("div#maincounter-wrap");
		elements.forEach(e -> {
		String text = e.select("h1").text();
		String value=e.getElementsByClass("maincounter-number").text();
		
		 response.setContentType("text/html"); 
			
		 String s= text+" "+value;
			out.println("<h3 style=\"height:50px;margin-left:100px\">"+s+"</h1>");
	});		
		out.println( "</center>"); 
		out.println("</div> </div></body></html>");
		
		
	}
}
