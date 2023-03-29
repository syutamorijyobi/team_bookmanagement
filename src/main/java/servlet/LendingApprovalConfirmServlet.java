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

import dao.BookDAO;
import dto.BookLogDTO;

/**
 * Servlet implementation class LendingApprovalConfirmServlet
 */
@WebServlet("/LendingApprovalConfirmServlet")
public class LendingApprovalConfirmServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LendingApprovalConfirmServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		HttpSession session=request.getSession();
//		UserDTO user = (UserDTO)session.getAttribute("user");
//		if(user == null){
//			String view = "./";
//			RequestDispatcher dispatcher = request.getRequestDispatcher(view);
//			dispatcher.forward(request, response);
//			return;
//		}
		int user_id=Integer.parseInt(request.getParameter("user_id"));
		List<BookLogDTO>book_log=BookDAO.Selectbooklog(1, user_id);
		session.setAttribute("lending_approval_log", book_log);
		String view="WEB-INF/view/lending_approval_confirm.jsp";
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
