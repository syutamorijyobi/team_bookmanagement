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

import dto.BookLogDTO;
import dto.UserDTO;

/**
 * Servlet implementation class ReturnRegisterListServlet
 */
@WebServlet("/ReturnRegisterServlet")
public class ReturnRegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReturnRegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		HttpSession session=request.getSession();
		UserDTO user = (UserDTO)session.getAttribute("user");
		if(user == null){
			String view = "./";
			RequestDispatcher dispatcher = request.getRequestDispatcher(view);
			dispatcher.forward(request, response);
			return;
		}
		int id=Integer.parseInt( request.getParameter("id"));
		int book_id=Integer.parseInt(request.getParameter("book_id"));
		BookLogDTO log=new BookLogDTO(id, user.getId(), 3, book_id, null, null, null);
		List<BookLogDTO>book_log_list=(ArrayList<BookLogDTO>)session.getAttribute("return");
		List<Integer>return_shedule=(ArrayList<Integer>)session.getAttribute("return_schedule");
		if(book_log_list==null) {
			List<BookLogDTO>if_book_log_list=new ArrayList<BookLogDTO>();
			if_book_log_list.add(log);
			session.setAttribute("return", if_book_log_list);
		}else {
			book_log_list.add(log);
		}
		if(return_shedule==null) {
			List<Integer>if_return_shchdule=new ArrayList<Integer>();
			if_return_shchdule.add(id);
			session.setAttribute("return_schedule", if_return_shchdule);
		}else {
			return_shedule.add(id);
		}
		String view=(String)session.getAttribute("beforeview");
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
