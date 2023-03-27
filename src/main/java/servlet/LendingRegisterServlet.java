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
import dto.UserDTO;

/**
 * Servlet implementation class LendingRegisterListServlet
 */
@WebServlet("/LendingRegisterServlet")
public class LendingRegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LendingRegisterServlet() {
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
		String title=request.getParameter("title");
		int isbn=Integer.parseInt( request.getParameter("isbn"));
		AllBookDTO book=new AllBookDTO(id, isbn, title, null, null, null, false, null);
		List<AllBookDTO>book_list=(ArrayList<AllBookDTO>)session.getAttribute("lending");
		if(book_list==null) {
			List<AllBookDTO>if_book_list=new ArrayList<AllBookDTO>();
			if_book_list.add(book);
			session.setAttribute("lending", if_book_list);
		}else {
			book_list.add(book);
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
