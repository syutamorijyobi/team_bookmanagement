package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDAO;
import mail.MailUtil;
import util.GenerateSalt;

/**
 * Servlet implementation class ForgetPasswordResultServlet
 */
@WebServlet("/ForgetPasswordResultServlet")
public class ForgetPasswordResultServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ForgetPasswordResultServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String email=request.getParameter("email");
		String salt=UserDAO.getSalt(email);
		if(salt==null) {
			request.setAttribute("email", email);
			String view = "WEB-INF/view/forgot-form.jsp?error=1";
			RequestDispatcher dispatcher = request.getRequestDispatcher(view);
			dispatcher.forward(request, response);
		}
		String path =GenerateSalt.getSalt(18);
		String title="パスワード変更メール";
		String contetn="パスワード変更してください。"
				+ "URL:http://localhost:8080/team_bookmanagement/ChangePasswdServlet?parameter="+path;
		MailUtil.sendMail(email, title, contetn);
		int result=UserDAO.registertentative(email, path);
		String view = "WEB-INF/view/forget-succes.jsp";
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
