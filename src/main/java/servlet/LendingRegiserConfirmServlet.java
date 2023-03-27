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

import dto.AllBookDTO;
import dto.BookLogDTO;
import dto.UserDTO;

/**
 * Servlet implementation class LendingConfirmServlet
 */
@WebServlet("/LendingRegisterConfirmServlet")
public class LendingRegiserConfirmServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LendingRegiserConfirmServlet() {
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
		List<BookLogDTO>book_log=new ArrayList<>();
		List<AllBookDTO> book= (ArrayList<AllBookDTO>)session.getAttribute("lending");
		for(AllBookDTO bo:book) {
			BookLogDTO log= new BookLogDTO(-1, user.getId(), 1, bo.getId(), null, null, null);
			book_log.add(log);
		}
		session.setAttribute("lending_log", book_log);
		String view ="WEB-INF/view/lending_register_confirm.jsp";
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
