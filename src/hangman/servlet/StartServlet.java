package hangman.servlet;

import hangman.controller.StartController;
import hangman.model.HMWord;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class StartServlet
 */
@WebServlet("/StartServlet")
public class StartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StartServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletContext context = getServletContext();
		InputStream is = context.getResourceAsStream("/res/words.txt");
		
		StartController wc = new StartController(is);
		HMWord word = wc.getWord();
		System.out.println(word.getWord());
		request.getSession().setAttribute("word", word);
		
		RequestDispatcher rd = request.getRequestDispatcher("/game.jsp");
		rd.forward(request, response);
	}


}
