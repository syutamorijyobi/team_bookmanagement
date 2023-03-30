package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dto.UserDTO;
import dto.User_ArticleDTO;

/**
 * Servlet implementation class RegisterReviewConfirmServlet
 */
@WebServlet("/RegisterReviewConfirmServlet")
public class RegisterReviewConfirmServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterReviewConfirmServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		UserDTO user = (UserDTO)session.getAttribute("user");
		if(user == null){
			String view = "./";
			RequestDispatcher dispatcher = request.getRequestDispatcher(view);
			dispatcher.forward(request, response);
			return;
		}
		
		request.setCharacterEncoding("UTF-8");
		
		int user_id = user.getId();
		int isbn = Integer.parseInt(request.getParameter("isbn"));
		int evaluation = Integer.parseInt(request.getParameter("evaluation"));
		String content = request.getParameter("content");
		
		User_ArticleDTO ua = new User_ArticleDTO(-1,user_id,isbn,content,evaluation,false);
	
		session.setAttribute("user_article", ua);
		
		String view = "WEB-INF/view/review_confirm.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(view);
		dispatcher.forward(request, response);	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
