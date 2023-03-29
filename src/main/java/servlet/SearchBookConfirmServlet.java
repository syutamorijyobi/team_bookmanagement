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
			
			String searchauthor = request.getParameter("search");
			AuthorDTO author = BookDAO.SelectAuthor_id(searchauthor);
			HttpSession session = request.getSession();
			session.setAttribute("search_author", author);
			String view = "WEB-INF/view/search_result.jsp";
			RequestDispatcher dispatcher = request.getRequestDispatcher(view);
			dispatcher.forward(request, response);
			
		} else if (sch.equals("publisher")) {
			// 入力された著者名を受け取る
			String searchpublisher = request.getParameter("search");

			
			PublisherDTO publisher = BookDAO.SelectPublisher_id(searchpublisher);
			HttpSession session = request.getSession();
			session.setAttribute("search_publisher", publisher);
			String view = "WEB-INF/view/search_result.jsp";
			RequestDispatcher dispatcher = request.getRequestDispatcher(view);
			dispatcher.forward(request, response);
			
		} else if (sch.equals("category")) {
			
			// 入力されたカテゴリ名を受け取る
			String searchcategory = request.getParameter("search");

			// 入力されたカテゴリ名を元にカテゴリIDを取得
			CategoryDTO categoryid = (CategoryDTO) BookDAO.SelectCategoty_id(searchcategory);

			// 取得したカテゴリIDを元にそのカテゴリIDと一致する本をISBNテーブルから取得
			List<IsbnDTO> searchresult = BookDAO.SearchBook(categoryid);

			// 取得した本のリストをリクエストスコープに保存
			request.setAttribute("searchresult", searchresult);
			
			// 結果表示用のJSPに画面遷移

			String view = "WEB-INF/view/search_result.jsp";
			RequestDispatcher dispatcher = request.getRequestDispatcher(view);
			dispatcher.forward(request, response);
			
		} else if (sch.equals("title")) {

			// 入力されたタイトルを受け取る
			String searchtitle = request.getParameter("title");

			// 入力されたタイトルを元にISBNテーブルから一致する本を祝
			IsbnDTO title = BookDAO.SelectTitle(searchtitle);


			// 取得した本のリストをリクエストスコープに保存

			// 結果表示用のJSPに画面遷移

	
			HttpSession session = request.getSession();
			session.setAttribute("search_title", title);
			String view = "WEB-INF/view/search_result.jsp";
			RequestDispatcher dispatcher = request.getRequestDispatcher(view);
			dispatcher.forward(request, response);
			
		}  else if (sch.equals("isbn")) {
			
			int serchisbn = Integer.parseInt(request.getParameter("search"));
			IsbnDTO isbn=BookDAO.SelectIsbn(serchisbn);
			HttpSession session = request.getSession();
			session.setAttribute("serch_isbn", isbn);
			String view = "WEB-INF/view/search_result.jsp";
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
