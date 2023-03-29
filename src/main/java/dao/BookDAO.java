package dao;

import java.net.URI;
import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import dto.AllBookDTO;
import dto.AuthorDTO;
import dto.BookDTO;
import dto.BookLogDTO;
import dto.CategoryDTO;
import dto.IsbnDTO;
import dto.PublisherDTO;
import dto.UserDTO;

public class BookDAO {
	private static Connection getConnection() throws URISyntaxException, SQLException {
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		URI dbUri = new URI(System.getenv("DATABASE_URL"));

		String username = dbUri.getUserInfo().split(":")[0];
		String password = dbUri.getUserInfo().split(":")[1];
		String dbUrl = "jdbc:postgresql://" + dbUri.getHost() + ':' + dbUri.getPort() + dbUri.getPath();

		return DriverManager.getConnection(dbUrl, username, password);
	}
	//登録
	public static int RegisterAuthor(AuthorDTO author) {
		String sql = "INSERT INTO project_author VALUES(default, ?, ?)";
		int result = 0;
		try (
				Connection con = getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);
				){
			pstmt.setString(1, author.getAuthor_name());
			pstmt.setString(2, author.getAuthor_hiragana());

			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (URISyntaxException e) {
			e.printStackTrace();
		} finally {
			System.out.println(result + "件更新しました。");
		}
		return result;
	}
	public static int RegisterPublisher(PublisherDTO publisher) {
		String sql = "INSERT INTO project_publisher VALUES(default, ?, ?)";
		int result = 0;
		try (
				Connection con = getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);
				){
			pstmt.setString(1, publisher.getPublisher_name());
			pstmt.setString(2, publisher.getPublisher_hiragana());

			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (URISyntaxException e) {
			e.printStackTrace();
		} finally {
			System.out.println(result + "件更新しました。");
		}
		return result;
	}
	public static int RegisterIsbn(IsbnDTO isbn) {
		String sql = "INSERT INTO project_isbn VALUES( ?, ?, ?, ?, ?)";
		int result = 0;
		try (
				Connection con = getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);
				){
			pstmt.setInt(1, isbn.getIsbn());
			pstmt.setString(2, isbn.getTitlel());
			pstmt.setInt(3, isbn.getAuthor_id());
			pstmt.setInt(4, isbn.getPublisher_id());
			pstmt.setInt(5, isbn.getCategory_id());

			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (URISyntaxException e) {
			e.printStackTrace();
		} finally {
			System.out.println(result + "件更新しました。");
		}
		return result;
	}
	public static int RegisterBook(BookDTO book) {
		String sql = "INSERT INTO project_book VALUES(default, ?, ?, default,current_timestamp)";
		int result = 0;
		try (
				Connection con = getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);
				){
			pstmt.setInt(1, book.getIsbn());
			pstmt.setString(2, book.getStatus());

			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (URISyntaxException e) {
			e.printStackTrace();
		} finally {
			System.out.println(result + "件更新しました。");
		}
		return result;
	}
	public static int RegisterBookLog(BookLogDTO log) {
		String sql = "INSERT INTO project_book_log VALUES(default, ?, ?, ?, ?,current_timestamp, ?)";
		int result = 0;
		Timestamp time=new Timestamp(System.currentTimeMillis());
		Timestamp time2=new Timestamp(70, 0, 30, 0, 0, 0, 0);
		long a=time.getTime()+time2.getTime();
		time.setTime(a);
		try (
				Connection con = getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);
				){
			pstmt.setInt(1,log.getUser_id() );
			pstmt.setInt(2, log.getDivision_id());
			pstmt.setInt(3, log.getBook_id());
			pstmt.setTimestamp(4,time);
			pstmt.setTimestamp(5, log.getReturn_at());

			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (URISyntaxException e) {
			e.printStackTrace();
		} finally {
			System.out.println(result + "件更新しました。");
		}
		return result;
	}
	//全件取得
	public static List<AuthorDTO> selectAllAuthor() {
		List<AuthorDTO> result = new ArrayList<>();
		String sql = "SELECT * FROM project_author";
		try (
				Connection con = getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);
				){
			try (ResultSet rs = pstmt.executeQuery()){
				while(rs.next()) {
					int id = rs.getInt("id");
					String author_name=rs.getString("author_name");
					String author_hiragana = rs.getString("author_hiragana");
					AuthorDTO au=new AuthorDTO(id, author_name, author_hiragana); 
					result.add(au);
				}
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}catch (URISyntaxException e) {
			e.printStackTrace();
		}
		return result;
	}
	public static List<PublisherDTO> selectAllPublisher() {
		List<PublisherDTO> result = new ArrayList<>();
		String sql = "SELECT * FROM project_publisher";
		try (
				Connection con = getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);
				){
			try (ResultSet rs = pstmt.executeQuery()){
				while(rs.next()) {
					int id = rs.getInt("id");
					String publisher_name=rs.getString("publisher_name");
					String publisher_hiragana = rs.getString("publisher_hiragana");
					PublisherDTO pu=new PublisherDTO(id, publisher_name, publisher_hiragana);
					result.add(pu);
				}
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}catch (URISyntaxException e) {
			e.printStackTrace();
		}
		return result;
	}
	public static List<CategoryDTO> selectAllCategory() {
		List<CategoryDTO> result = new ArrayList<>();
		String sql = "SELECT * FROM project_category";
		try (
				Connection con = getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);
				){
			try (ResultSet rs = pstmt.executeQuery()){
				while(rs.next()) {
					int id = rs.getInt("id");
					String category_name=rs.getString("category_name");
					CategoryDTO ca=new CategoryDTO(id, category_name);
					result.add(ca);
				}
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}catch (URISyntaxException e) {
			e.printStackTrace();
		}
		return result;
	}

	public static List<BookLogDTO> selectAllBookLog() {
		List<BookLogDTO> result = new ArrayList<>();
		String sql = "SELECT * FROM project_book_log";
		try (
				Connection con = getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);
				){
			try (ResultSet rs = pstmt.executeQuery()){
				while(rs.next()) {
					int id = rs.getInt("id");
					int user_id=Integer.parseInt( rs.getString("user_id"));
					int division_id =Integer.parseInt( rs.getString("division_id"));
					int book_id=rs.getInt("book_id");
					Timestamp deadline_at = rs.getTimestamp("leadline_at");
					Timestamp lending_at = rs.getTimestamp("lending_at");
					Timestamp return_at=rs.getTimestamp("return_at");
					BookLogDTO log=new BookLogDTO(id, user_id, division_id, book_id, deadline_at, lending_at, return_at);
					result.add(log);
				}
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}catch (URISyntaxException e) {
			e.printStackTrace();
		}
		return result;
	}
	public static List<BookDTO> selectAllBook() {
		List<BookDTO> result = new ArrayList<>();
		String sql = "SELECT * FROM project_book";
		try (
				Connection con = getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);
				){
			try (ResultSet rs = pstmt.executeQuery()){
				while(rs.next()) { 
					int id = rs.getInt("id");
					int isbn =rs.getInt("isbn");
					String staus=rs.getString("status");
					boolean condition=rs.getBoolean("condition");
					BookDTO book=new BookDTO(id, isbn, staus, condition, null);
					result.add(book);
				}
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}catch (URISyntaxException e) {
			e.printStackTrace();
		}
		return result;
	}
	public static List<IsbnDTO> selectAllIsbn() {
		List<IsbnDTO> result = new ArrayList<>();
		String sql = "SELECT * FROM project_isbn";
		try (
				Connection con = getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);
				){
			try (ResultSet rs = pstmt.executeQuery()){
				while(rs.next()) {
					int id = rs.getInt("isbn");
					String title=rs.getString("title");
					int author_id =rs.getInt("author_id");
					int publisher_id=rs.getInt("publisher_id");
					int category_id=rs.getInt("category_id");
					IsbnDTO isbn=new IsbnDTO(id, title, author_id, publisher_id, category_id);
					result.add(isbn);
				}
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}catch (URISyntaxException e) {
			e.printStackTrace();
		}
		return result;
	}
	//検索
	public static IsbnDTO SelectIsbn(int num) {

		String sql = "SELECT * FROM project_isbn WHERE isbn = ?";

		try (
				Connection con = getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);
				){
			pstmt.setInt(1, num);

			try (ResultSet rs = pstmt.executeQuery()){

				if(rs.next()) {
					int is=rs.getInt("isbn");
					String title=rs.getString("title");
					int author_id=rs.getInt("author_id");
					int publisher_id=rs.getInt("publisher_id");
					int category_id=rs.getInt("category_id");

					return new IsbnDTO(is, title, author_id, publisher_id, category_id);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static List<BookLogDTO> SerchBookloguserid(int num) {

		String sql = "select DISTINCT user_id from project_book_log where division_id = ? ";
		List<BookLogDTO>result=new ArrayList<>();
		try (
				Connection con = getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);
				){
			pstmt.setInt(1,num);
			try (ResultSet rs = pstmt.executeQuery()){
				while(rs.next()) {
					int user_id=rs.getInt("user_id");
					BookLogDTO book=new BookLogDTO(0, user_id, num, 0, null, null, null);
					result.add(book);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (URISyntaxException e) {
			e.printStackTrace();
		} finally {
			System.out.println(result + "件検索しました。");
		}
		return result;
	}
	public static UserDTO SelectUserMail(int num) {
		String sql = "select name,mail from project_user where id = ?";

		try (
				Connection con = getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);
				){
			pstmt.setInt(1, num);

			try (ResultSet rs = pstmt.executeQuery()){

				if(rs.next()) {
					String name=rs.getString("name");
					String mail=rs.getString("mail");
					UserDTO user=new UserDTO(num, name, mail, null, null, null);
					return user;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
		return null;
	}
	public static List<BookLogDTO> Selectbooklog(int num ,int user) {
		List<BookLogDTO> result = new ArrayList<>();
		String sql = "SELECT * FROM project_book_log WHERE user_id= ? AND division_id = ?";

		try (
				Connection con = getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);
				){
			pstmt.setInt(1, user);
			pstmt.setInt(2, num);

			try (ResultSet rs = pstmt.executeQuery()){

				if(rs.next()) {
					int id=rs.getInt("id");
					int user_id=rs.getInt("user_id");
					int division_id=rs.getInt("division_id");
					int book_id=rs.getInt("book_id");
					Timestamp deadline_at=rs.getTimestamp("deadline_at");
					Timestamp lending_at=rs.getTimestamp("lending_at");
					Timestamp return_at=rs.getTimestamp("return_at");
					BookLogDTO log=new BookLogDTO(id, user_id, division_id, book_id, deadline_at, lending_at, return_at);
					result.add(log);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
		return result;
	}
	//更新
	public static int BookDivisionUpdate(BookLogDTO log) {
		String sql = "UPDATE project_book_log set division_id = ? where id = ?";
		int result = 0;

		try (
				Connection con = getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);
				){
			pstmt.setInt(1,log.getDivision_id());
			pstmt.setInt(2, log.getId());

			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (URISyntaxException e) {
			e.printStackTrace();
		} finally {
			System.out.println(result + "件を更新しました。");
		}
		return result;
	}
	//削除
	public static int DROPIsbn(IsbnDTO drop2) {

		String sql = "DELETE from  project_isbn Where ISBN =?";

		// return用の変数
		int result = 0;

		try (
				Connection con = getConnection();	// DB接続
				PreparedStatement pstmt = con.prepareStatement(sql);			// 構文解析
				){


			pstmt.setInt(1, drop2.getIsbn());

			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (URISyntaxException e) {
			e.printStackTrace();
		} finally {
			System.out.println(result + "件削除しました。");
		}
		return result;
	}
	public static int DROPpublisher(PublisherDTO drop4) {


		String sql = "DELETE from  project_Publisher Where publisher_name =?";

		// return用の変数
		int result = 0;

		try (
				Connection con = getConnection();	// DB接続
				PreparedStatement pstmt = con.prepareStatement(sql);			// 構文解析
				){
			pstmt.setString(1, drop4.getPublisher_name());

			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (URISyntaxException e) {
			e.printStackTrace();
		} finally {
			System.out.println(result + "件削除しました。");
		}
		return result;
	}
	public static int DROPAuthor(AuthorDTO drop5) {


		String sql = "DELETE from  project_Author Where author_name =?";

		// return用の変数
		int result = 0;

		try (
				Connection con = getConnection();	// DB接続
				PreparedStatement pstmt = con.prepareStatement(sql);			// 構文解析
				){

			pstmt.setString(1, drop5.getAuthor_name());

			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (URISyntaxException e) {
			e.printStackTrace();
		} finally {
			System.out.println(result + "件削除しました。");
		}
		return result;
	}
	public static int DROPbook(BookDTO drop) {


		String sql = "DELETE from  project_book Where ISBN =?";

		// return用の変数
		int result = 0;

		try (
				Connection con = getConnection();	// DB接続
				PreparedStatement pstmt = con.prepareStatement(sql);			// 構文解析
				){
			pstmt.setInt(1, drop.getIsbn());
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (URISyntaxException e) {
			e.printStackTrace();
		} finally {
			System.out.println(result + "件削除しました。");
		}
		return result;
	}
	public static List<AllBookDTO> IntegrationOne(List<BookDTO> book_list,List<IsbnDTO> isbn_list,List<PublisherDTO> publisher_list,List<AuthorDTO> author_list,List<CategoryDTO> category_list){
		List<AllBookDTO> all_book=new ArrayList<AllBookDTO>();
		int id;
		int isbn;
		String publisher;
		String author;
		String category;
		String title;
		String status;
		boolean condition;
		for(BookDTO bk:book_list){
			for(IsbnDTO is:isbn_list) {
				for(PublisherDTO pu:publisher_list) {
					for(AuthorDTO au:author_list) {
						for(CategoryDTO ca:category_list) {
							if(bk.getIsbn()==is.getIsbn()&&is.getPublisher_id()==pu.getId()&&is.getAuthor_id()==au.getId()&&is.getCategory_id()==ca.getId()) {
								id=bk.getId();
								isbn=is.getIsbn();
								title=is.getTitlel();
								status=bk.getStatus();
								condition=bk.isCondition();
								publisher=pu.getPublisher_name();
								author=au.getAuthor_name();
								category=ca.getCategory_name();
								AllBookDTO all=new AllBookDTO(id, isbn, title, author, publisher, category, condition, status);
								all_book.add(all);
							}
						}
					}
				}
			}
		}
		return all_book;
	}
}
