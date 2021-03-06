package com.game.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.game.util.MultiUtil;

/**
 * Servlet implementation class InitiateServlet
 * This servlet is used to create user information for all the users 
 * It will set the secret number and generate the uuid for each user
 */
public class InitiateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/plain");
		PrintWriter printWriter = response.getWriter();
		String user = java.util.UUID.randomUUID().toString();
		int secretNo = MultiUtil.getSecretNumber();
		MultiUtil.getUserSecretNumber().put(user, secretNo);
		MultiUtil.getUserAttemptsLeft().put(user, 0);
		printWriter.write(user);
		printWriter.close();
		
	}

}
