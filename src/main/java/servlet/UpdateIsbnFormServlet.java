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
import dto.UserDTO;

/**
 * Servlet implementation class UpdateIsbnFormServlet
 */
@WebServlet("/UpdateIsbnFormServlet")
public class UpdateIsbnFormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateIsbnFormServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		HttpSession session=request.getSession();
		UserDTO user = (UserDTO)session.getAttribute("root");
		if(user == null){
			String view = "./";
			RequestDispatcher dispatcher = request.getRequestDispatcher(view);
			dispatcher.forward(request, response);
			return;
		}
		int id=Integer.parseInt(request.getParameter("id"));
		IsbnDTO isbn_list=BookDAO.SelectIsbn(id);
		session.setAttribute("update_isbn", isbn_list);
		List<AuthorDTO> author_list=BookDAO.selectAllAuthor();
		session.setAttribute("root_author_list", author_list);
		List<PublisherDTO> publisher_list=BookDAO.selectAllPublisher();
		session.setAttribute("root_publisher_list", publisher_list);
		List<CategoryDTO> category_list=BookDAO.selectAllCategory();
		session.setAttribute("root_category_list", category_list);
		String view = "WEB-INF/view/update_isbn_form.jsp";
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
