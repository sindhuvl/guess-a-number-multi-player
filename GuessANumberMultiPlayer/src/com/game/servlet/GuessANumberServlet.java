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
/**
 * 
 * @author Sindhu VL
 *This is a servlet which handles the requests from JSP page
 */
@SuppressWarnings("serial")
public class GuessANumberServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/plain");
		
		//Once the browser tab is opened, uuid is generated for each tab to differentiate the users in each tab.
		Map<String, Integer> userSecretMap = MultiUtil.getUserSecretNumber();
		Map<String, Integer> userAttempts = MultiUtil.getUserAttemptsLeft();
		
		String userId = req.getParameter("playerId");
		
		
		int secretNumber = userSecretMap.get(userId);
		int attempt = userAttempts.get(userId);
		
		attempt = attempt + 1;
		
		//Creating a map with user is and attempts
		userAttempts.put(userId, attempt);
		
		//Providing the validations if no input is given and the attempt is lost
		if (req.getParameter("guess") == null || req.getParameter("guess") == "") {
			resp.getWriter().write("You have lost an attempt, Please enter a valid number");
			return;
		}
		
		if(Integer.parseInt(req.getParameter("guess")) > 10 || Integer.parseInt(req.getParameter("guess")) < 1){
			resp.getWriter().write("You have lost an attempt, Please enter a valid number");
			return;
		}
		
		int guess = Integer.parseInt(req.getParameter("guess"));
		
		//Building the message to be shown using the given guess and the generated secret number.
		String output = GuessGameUtil.guessStatus(secretNumber, guess, attempt);
		
		//When there is right guess found, then resetting the secret number and attempts to Zero So that there would be a fresh start of the game.
		if (output.contains("won") || output.contains("Game Over")) {
			userAttempts.put(userId, 0);
			
			secretNumber = MultiUtil.getSecretNumber();
			userSecretMap.put(userId, secretNumber);
		}
		
		PrintWriter printWriter = resp.getWriter();
		printWriter.println(output);

	}
}
