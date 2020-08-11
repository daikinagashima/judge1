package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Post;
import model.PostLogic;

/**
 * Servlet implementation class PostServlet
 */
@WebServlet("/PostServlet")
public class PostServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public PostServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		RequestDispatcher dispatcher =
				request.getRequestDispatcher("WEB-INF/jsp/post.jsp");
		dispatcher.forward(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		String pattern1 = request.getParameter("pattern1");
		String pattern2 = request.getParameter("pattern2");

		HttpSession session = request.getSession(false);

		String name = (String)session.getAttribute("name");


		Post post = new Post(name,title,content,pattern1,pattern2);

		PostLogic bo = new PostLogic();
		bo.execute(post);

		request.setAttribute("title",title);
		request.setAttribute("content",content);
		request.setAttribute("pattern1",pattern1);
		request.setAttribute("pattern2",pattern2);
		request.setAttribute("name",name);

		RequestDispatcher dispatcher =
				request.getRequestDispatcher("WEB-INF/jsp/posted.jsp");
		dispatcher.forward(request, response);
	}

}
