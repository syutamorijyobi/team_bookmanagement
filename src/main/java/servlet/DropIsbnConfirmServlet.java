package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dto.IsbnDTO;

/**
 * Servlet implementation class DropIsbnConfirmServlet
 */
@WebServlet("/DropIsbnConfirmServlet")
public class DropIsbnConfirmServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DropIsbnConfirmServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
		
		int isbn =Integer.parseInt( request.getParameter("isbn"));
		String title = request.getParameter("title");
		int author_id =Integer.parseInt( request.getParameter("author_id"));
		int publisher_id =Integer.parseInt( request.getParameter("publisher_id"));
		int category_id =Integer.parseInt( request.getParameter("category_id"));
		
		IsbnDTO drop2 = new IsbnDTO(isbn, title, author_id, publisher_id, category_id);
		
		HttpSession session = request.getSession();
		
		session.setAttribute("input_isbn", drop2);
		
		String view = "WEB-INF/view/drop_isbn_confirm.jsp";
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
