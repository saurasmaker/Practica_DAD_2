package edu.ucam.servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.ucam.classes.User;
import edu.ucam.database.LoadDataReferences;
import edu.ucam.database.SaveDataByReference;

/**
 * Servlet implementation class AddUser
 */
@WebServlet("/AddUser")
public class AddUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddUser() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		User newUser = new User();
		newUser.setUsername(request.getParameter(User.USER_USERNAME_PARAM));
		newUser.setEmail(request.getParameter(User.USER_EMAIL_PARAM));
		newUser.setPassword(request.getParameter(User.USER_PASSWORD_PARAM));
		newUser.setAddress(request.getParameter(User.USER_ADDRESS_PARAM));
		
		String biography;
		if((biography = request.getParameter(User.USER_BIOGRAPHY_PARAM)) == null) newUser.setBiography("NULL");
		else newUser.setBiography(biography);
		
		if(newUser.getUsername()!=null) {
			ArrayList<String> usersReferences = new ArrayList<String>();
			LoadDataReferences.loadUsersReferences(usersReferences);	
		
			User.generateIdByReference(newUser, usersReferences.get(usersReferences.size()-1));
		
			SaveDataByReference.User(newUser);
		}
		request.getRequestDispatcher("/GoTo?GO_TO=/src/administer.jsp").forward(request, response);
		
		return;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
