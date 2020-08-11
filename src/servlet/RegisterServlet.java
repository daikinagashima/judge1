package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.RegisterDAO;
import model.RegisterUserLogic;
import model.User;


/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");

		String name = request.getParameter("name");
		String pass = request.getParameter("pass");

		String errorMsg = null;

			User user = new User(name,pass);
			RegisterUserLogic registerUserLogic = new RegisterUserLogic();
			registerUserLogic.execute(user);

			//ユーザ登録失敗

			RegisterDAO reg = new RegisterDAO();
			if(reg.findName(name)) {
				request.setAttribute("name", name);
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/registercom.jsp");
				dispatcher.forward(request, response);
			}else {

				errorMsg = "既にそのユーザ名は使われております。";
				request.setAttribute("errorMsg",errorMsg);
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/register.jsp");

				dispatcher.forward(request, response);


		}



		/*****

		HttpSession session = request.getSession();
        session.setAttribute("user", user);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/registerCom.jsp");
        dispatcher.forward(request, response);
        *****/
	}

}
