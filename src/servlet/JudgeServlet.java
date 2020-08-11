package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.PostDAO;
import model.GetPostListLogic;
import model.Judge_List;
import model.Post;

/**
 * Servlet implementation class JudgeServlet
 */
@WebServlet("/JudgeServlet")
public class JudgeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public JudgeServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		GetPostListLogic getPostListLogic = new GetPostListLogic();
		List<Post> postList = getPostListLogic.execute();
		request.setAttribute("postList", postList);

		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/watch.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		//投票数を++にする
		int p = Integer.parseInt(request.getParameter("pattern"));
		int number = Integer.parseInt(request.getParameter("number"));
		String name = request.getParameter("name");
		String title = request.getParameter("title");
		String content = request.getParameter("content");



		PostDAO dao = new PostDAO();

		if(p == 1) {
			dao.addJudge("PATTERN1_NUM",number);
			System.out.println("ok");
		}else if(p == 2) {
			dao.addJudge("PATTERN2_NUM",number);
			System.out.println("ok");
		}else {

			System.out.println("error");
		}

//		JUDGE_LISTにナンバーと投票した人の名前を登録
		HttpSession session = request.getSession(false);

		String judge_name =(String)session.getAttribute("name");

		Judge_List bo = new Judge_List();
		bo.execute(number, judge_name);

//		選択肢の投票数を出力するためにデータベースからselectする
		int p1_num = dao.getPattern1_num(number);
		int p2_num = dao.getPattern2_num(number);


//		最後にリクエストスコープにセットする

		String pattern1 = dao.getPattern1(number);
		String pattern2 = dao.getPattern2(number);

		request.setAttribute("title",title);
		request.setAttribute("content",content);
		request.setAttribute("pattern1",pattern1);
		request.setAttribute("pattern2",pattern2);
		request.setAttribute("name",name);
		request.setAttribute("pattern1_num", p1_num);
		request.setAttribute("pattern2_num", p2_num);

		RequestDispatcher dispatcher =
				request.getRequestDispatcher("WEB-INF/jsp/judged.jsp");
		dispatcher.forward(request, response);

	}

}
