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
import dto.AuthorDTO;
import dto.CategoryDTO;
import dto.IsbnDTO;
import dto.PublisherDTO;

/**
 * Servlet implementation class UpdateIsbnConfirmServlet
 */
@WebServlet("/UpdateIsbnConfirmServlet")
public class UpdateIsbnConfirmServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateIsbnConfirmServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		List<AuthorDTO> author_list=BookDAO.selectAllAuthor();
		List<PublisherDTO> publisher_list=BookDAO.selectAllPublisher();
		List<CategoryDTO> category_list=BookDAO.selectAllCategory();
		session.setAttribute("author_list", author_list);
		session.setAttribute("publisher_list", publisher_list);
		session.setAttribute("category_list", category_list);
		int isbn=Integer.parseInt( request.getParameter("isbn"));
		String title=request.getParameter("title");
		int author_id =Integer.parseInt( request.getParameter("author_id"));
		int publisher_id =Integer.parseInt( request.getParameter("publisher_id"));
		int category_id =Integer.parseInt( request.getParameter("category_id"));
		IsbnDTO is=new IsbnDTO(isbn, title, author_id, publisher_id, category_id);
		session.setAttribute("input_update_isbn", is);
		
		String view = "WEB-INF/view/update_isbn_confirm.jsp";
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
