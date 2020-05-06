package edu.ucam.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.ucam.classes.Comment;
import edu.ucam.classes.Vote;
import edu.ucam.database.RemoveElementByReference;

/**
 * Servlet implementation class RemoveVote
 */
@WebServlet("/RemoveVote")
public class RemoveVote extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RemoveVote() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id = request.getParameter(Vote.VOTE_ID_PARAM);
		
		
		if(id!=null)
			RemoveElementByReference.vote(id);
		
		request.getRequestDispatcher("/GoTo?GO_TO=/src/administer.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	
	private Boolean canRemove() {
		
		
		return false;
	}
}
