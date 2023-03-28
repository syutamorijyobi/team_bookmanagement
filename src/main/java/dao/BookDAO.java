package dao;

import java.net.URI;
import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dto.AuthorDTO;
import dto.BookDTO;
import dto.CategoryDTO;
import dto.IsbnDTO;
import dto.PublisherDTO;

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
public static int DROPbook(BookDTO drop) {
	
		
		String sql = "DELETE from  project_book Where ISBN =?";

		// return用の変数
		int result = 0;
		
		try (
				Connection con = getConnection();	// DB接続
				PreparedStatement pstmt = con.prepareStatement(sql);			// 構文解析
				){
	
		
			pstmt.setInt(1, drop.getIsbn());

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

}
