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
import dto.BookLogDTO;
import dto.CategoryDTO;
import dto.IsbnDTO;
import dto.PublisherDTO;

/**
 * Servlet implementation class ReturnApprovalConfirmServlet
 */
@WebServlet("/ReturnApprovalConfirmServlet")
public class ReturnApprovalConfirmServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReturnApprovalConfirmServlet() {
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
		List<AuthorDTO> author_list=BookDAO.selectAllAuthor();
		List<PublisherDTO>pulisher_list=BookDAO.selectAllPublisher();
		List<CategoryDTO>category_list=BookDAO.selectAllCategory();
		List<IsbnDTO>isbn_list=BookDAO.selectAllIsbn();
		List<BookDTO>book_list=BookDAO.selectAllBook();
		List<AllBookDTO>all_list=BookDAO.IntegrationOne(book_list, isbn_list, pulisher_list, author_list, category_list);
		session.setAttribute("book_list", all_list);
		int user_id=Integer.parseInt(request.getParameter("user_id"));
		List<BookLogDTO>book_log=BookDAO.Selectbooklog(3, user_id);
		session.setAttribute("return_approval_log", book_log);
		String view="WEB-INF/view/return_approval_confirm.jsp";
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
