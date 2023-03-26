package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.BookDAO;
import dao.UserDAO;
import dto.BookLogDTO;
import dto.UserDTO;
import mail.MailUtil;

/**
 * Servlet implementation class LendingRegisterExecuteServlet
 */
@WebServlet("/LendingRegisterExecuteServlet")
public class LendingRegisterExecuteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LendingRegisterExecuteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		UserDTO user = (UserDTO)session.getAttribute("user");
		if(user == null){
			String view = "./";
			RequestDispatcher dispatcher = request.getRequestDispatcher(view);
			dispatcher.forward(request, response);
			return;
		}
		List<BookLogDTO>book_log=(ArrayList<BookLogDTO>)session.getAttribute("lending_log");
		for(BookLogDTO bo:book_log) {
			BookDAO.RegisterBookLog(bo);
		}
		List<UserDTO>root_list=UserDAO.selectAllRoot();
		for(UserDTO us:root_list) {
			String mail=UserDAO.SelectUser(us.getId());
			if(mail!=null) {
				String title="図書貸出申請";
				String content=user.getName()+"さんから図書の貸出申請が送信されました。"
						+ "承認待ち状態です。";
				MailUtil.sendMail(mail, title, content);	
			}
		}
		session.removeAttribute("lending_log");
		String view ="WEB-INF/view/lending_register_success.jsp";
		RequestDispatcher dispatcher=request.getRequestDispatcher(view);
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
