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
import dto.PublisherDTO;

/**
 * Servlet implementation class DropAuthorExecuteServlet
 */
@WebServlet("/DropPublisherExecuteServlet")
public class DropPublisherExecuteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
                   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DropPublisherExecuteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
		
		PublisherDTO publisher = (PublisherDTO)session.getAttribute("input_author");
		
		int result = BookDAO.DROPpublisher(publisher);
		
		String path = "";
		if(result == 1) {
			session.removeAttribute("input_author");
			path = "WEB-INF/view/drop_author_success.jsp";
		} else {
			path = "WEB-INF/view/drop_author_form.jsp?error=1";
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher(path);
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
