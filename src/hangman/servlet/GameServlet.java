package hangman.servlet;

import hangman.model.HMWord;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class GameServlet
 */
@WebServlet("/GameServlet")
public class GameServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public GameServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HMWord word = (HMWord) request.getSession().getAttribute("word");
		String letter = request.getParameter("letter");
		word.checkGuess(letter.charAt(0));
		
		request.getSession().setAttribute("word", word);
		
		boolean cont = word.canContinue();
		
		RequestDispatcher rd;
	
		if(cont) {
			rd = request.getRequestDispatcher("game.jsp");			
		}else {
			rd = request.getRequestDispatcher("GameOver.jsp");		
		}
		rd.forward(request, response);
	}

}
