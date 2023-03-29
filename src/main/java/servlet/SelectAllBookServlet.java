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
import dto.AllBookDTO;
import dto.AuthorDTO;
import dto.BookDTO;
import dto.CategoryDTO;
import dto.IsbnDTO;
import dto.PublisherDTO;

/**
 * Servlet implementation class SelectAllBookServlet
 */
@WebServlet("/SelectAllBookServlet")
public class SelectAllBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SelectAllBookServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<AuthorDTO> author_list=BookDAO.selectAllAuthor();
		List<PublisherDTO>pulisher_list=BookDAO.selectAllPublisher();
		List<CategoryDTO>category_list=BookDAO.selectAllCategory();
		List<IsbnDTO>isbn_list=BookDAO.selectAllIsbn();
		List<BookDTO>book_list=BookDAO.selectAllBook();
		List<AllBookDTO>all_list=BookDAO.IntegrationOne(book_list, isbn_list, pulisher_list, author_list, category_list);
		HttpSession session = request.getSession();
		session.setAttribute("book_list", all_list);
		String view ="WEB-INF/view/book_list.jsp";
		session.setAttribute("beforeview", view);
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
