package com.paula.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import com.paula.utils.Utils;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/NumeroController")
public class NumeroController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public NumeroController() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Utils util = new Utils();
		Double numeroRandom = util.calculaAleatorio();
		
		response.setContentType("text/html");

		PrintWriter out = response.getWriter();
		
		out.print("<html> <body>");
		out.print("<h1> Número aleatorio: "+ numeroRandom +" </h1>");
		out.print("</body> </html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
