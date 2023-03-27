package servlet;

import java.io.IOException;

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
 * Servlet implementation class SearchBookConfirmServlet
 */
@WebServlet("/SearchBookConfirmServlet")
public class SearchBookConfirmServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchBookConfirmServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String sch = request.getParameter("sch");
		if(sch.equals("author")) {
			
			String searchauthor = request.getParameter("author_name");
			AuthorDTO author = BookDAO.SelectAuthor_id(searchauthor);
			HttpSession session = request.getSession();
			session.setAttribute("search_author", author);
			String view = "WEB-INF/view/search_result_author.jsp";
			RequestDispatcher dispatcher = request.getRequestDispatcher(view);
			dispatcher.forward(request, response);
			
		} else if (sch.equals("publisher")) {
			
			String searchpublisher = request.getParameter("publisher_name");
			PublisherDTO publisher = BookDAO.SelectPublisher_id(searchpublisher);
			HttpSession session = request.getSession();
			session.setAttribute("search_publisher", publisher);
			String view = "WEB-INF/view/search_result_book.jsp";
			RequestDispatcher dispatcher = request.getRequestDispatcher(view);
			dispatcher.forward(request, response);
			
		} else if (sch.equals("category")) {
			
			String searchcategory = request.getParameter("category_name");
			CategoryDTO category_name = (CategoryDTO) BookDAO.SelectCategoty_id(searchcategory);
			HttpSession session = request.getSession();
			session.setAttribute("search_category", category_name);
			String view = "WEB-INF/view/search_result_book.jsp";
			RequestDispatcher dispatcher = request.getRequestDispatcher(view);
			dispatcher.forward(request, response);
			
		} else if (sch.equals("title")) {
			
			String searchtitle = request.getParameter("title");
			IsbnDTO title = BookDAO.SelectTitle(searchtitle);
			HttpSession session = request.getSession();
			session.setAttribute("search_title", title);
			String view = "WEB-INF/view/search_result_book.jsp";
			RequestDispatcher dispatcher = request.getRequestDispatcher(view);
			dispatcher.forward(request, response);
			
		}  else if (sch.equals("isbn")) {
			
			int serchisbn = Integer.parseInt(request.getParameter("isbn"));
			IsbnDTO isbn=BookDAO.SelectIsbn(serchisbn);
			HttpSession session = request.getSession();
			session.setAttribute("serch_isbn", isbn);
			String view = "WEB-INF/view/search_result_book.jsp";
			RequestDispatcher dispatcher = request.getRequestDispatcher(view);
			dispatcher.forward(request, response);
			
		} else {
			
			String view = "WEB-INF/view/search_book_form.jsp";
			RequestDispatcher dispatcher = request.getRequestDispatcher(view);
			dispatcher.forward(request, response);
		}
		

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
