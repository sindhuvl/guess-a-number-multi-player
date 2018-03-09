package com.game.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.game.util.GuessGameUtil;
import com.game.util.MultiUtil;

@SuppressWarnings("serial")
public class GuessANumberServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/plain");
		
		Map<String, Integer> userSecretMap = MultiUtil.getUserSecretNumber();
		Map<String, Integer> userAttempts = MultiUtil.getUserAttemptsLeft();
		
		String userId = req.getParameter("playerId");
		
		int secretNumber = userSecretMap.get(userId);
		int attempt = userAttempts.get(userId);
		
		attempt = attempt + 1;
		
		userAttempts.put(userId, attempt);
		if (req.getParameter("guess") == null || req.getParameter("guess") == "") {
			resp.getWriter().write("You have lost an attempt, Please enter a valid number");
			return;
		}
		
		if(Integer.parseInt(req.getParameter("guess")) > 10 || Integer.parseInt(req.getParameter("guess")) < 1){
			resp.getWriter().write("You have lost an attempt, Please enter a valid number");
			return;
		}
		System.out.println("secret Number ---> " + secretNumber);
		System.out.println("secret attempt ---> " + attempt);
		int guess = Integer.parseInt(req.getParameter("guess"));
		String output = GuessGameUtil.guessStatus(secretNumber, guess, attempt);
		if (output.contains("won") || output.contains("Game Over")) {
			userAttempts.put(userId, 0);
			
			secretNumber = MultiUtil.getSecretNumber();
			userSecretMap.put(userId, secretNumber);
		}
		PrintWriter printWriter = resp.getWriter();
		printWriter.println(output);

	}
}
