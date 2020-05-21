package edu.ucam.actions;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.ucam.classes.User;
import edu.ucam.database.RemoveElementByReference;


public class RemoveUser extends Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String id = request.getParameter(User.USER_ID_PARAM);

		if(id!=null)
			RemoveElementByReference.user(id);
		
		return "/GoTo?GO_TO=/src/administer.jsp";
	}

}
